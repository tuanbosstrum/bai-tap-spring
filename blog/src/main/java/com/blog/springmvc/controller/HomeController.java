package com.blog.springmvc.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.blog.springmvc.core.Render;
import com.blog.springmvc.entity.Comment;
import com.blog.springmvc.entity.Customer;
import com.blog.springmvc.entity.Post;
import com.blog.springmvc.entity.Tag;
import com.blog.springmvc.service.IService;

@Controller
@SessionAttributes("setCustomer")
@RequestMapping("/home")
public class HomeController extends Render {

	@Autowired
	ServletContext context;
	@Autowired
	private IService<Customer> customerService;
	@Autowired
	private IService<Post> postService;
	@Autowired
	private IService<Tag> tagService;
	@Autowired
	private IService<Comment> commentService;

	@GetMapping("/login")
	public String viewLogin(Model model) {
		SetPage(model, "Trang chủ - Đăng nhập", "fragments/home/login");
		model.addAttribute("customer", new Customer());
		return View();
	}

	@PostMapping("/login")
	public String submitLogin(Model model, @ModelAttribute("customer") Customer customer) {
		if (customerService.findByObject(customer) != null) {
			model.addAttribute("setCustomer", customerService.findByObject(customer));
			return viewIndex(model);
		} else {
			return "redirect:login";
		}
	}

	@GetMapping("/register")
	public String viewRegister(Model model) {
		SetPage(model, "Trang chủ - Đăng ký", "fragments/home/register");
		model.addAttribute("customer", new Customer());
		return View();
	}

	@PostMapping("/register")
	public String submitRegister(@ModelAttribute("customer") Customer customer,
			@RequestParam("repassword") String repassword) {
		if (repassword.equals(customer.getPassword())) {
			customerService.save(customer);
			return "redirect:login";
		} else {
			return "redirect:register";
		}

	}

	@GetMapping("/")
	public String viewIndex(Model model) {

		return viewIndexHome(model, 1, "id", "asc");
	}

	@GetMapping("/create")
	public String viewCreatePost(Model model) {
		SetPage(model, "Trang chủ - Đăng bài", "fragments/home/create");
		model.addAttribute("tags", tagService.findAll());
		model.addAttribute("post", new Post());
		return View();
	}

	@GetMapping("/page")
	public String viewIndexHome(Model model, @RequestParam("num") int num, @RequestParam("field") String field,
			@RequestParam("dir") String dir) {
		SetPage(model, "Trang chủ", "fragments/home/index");
		model.addAttribute("currentPage", num);
		model.addAttribute("field", field);
		model.addAttribute("dir", dir);
		model.addAttribute("reverseSortDir", dir.equals("asc") ? "desc" : "asc");
		model.addAttribute("tags", tagService.findAll());
		model.addAttribute("posts", postService.findPage(num, field, dir));
		model.addAttribute("tags", tagService.findAll());
		return View();
	}

	@PostMapping("/create")
	public String submitCreate(@ModelAttribute("post") Post post, @SessionAttribute("setCustomer") Customer customer,
			@RequestParam("photo") MultipartFile photo) {
		post.setAuth(customer);
		String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
		post.setImage(fileName);
		if (postService.save(post) == true) {
			String uploadDir = context.getRealPath("resources/uploads/post"); // SERVER PATH
			// String uploadDir =
			// "C:\\Users\\Admin\\eclipse-workspace\\blog\\src\\main\\webapp\\resources\\uploads\\post";
			// // Local path
			try {
				saveFile(uploadDir, fileName, photo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/home/";
		}
		return "redirect:create";
	}

	@GetMapping("/comment")
	public String viewComment(Model model, @RequestParam("postId") long id) {
		SetPage(model, "Bình luận", "fragments/home/comment");
		Post post = postService.findById(id);
		post.setComments(commentService.findByAllObjectId(id));
		model.addAttribute("post", post);
		model.addAttribute("comment", new Comment());
		return View();
	}

	@PostMapping("/saveComment")
	public String submitComment(@ModelAttribute("comment") Comment comment, @RequestParam("postId") long id,
			@SessionAttribute("setCustomer") Customer customer) {
		if (customer != null) {
			comment.setCustomer(customer);
			comment.setPost(postService.findById(id));
			commentService.save(comment);
		}
		return "redirect:comment?postId=" + id;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/like")
	public String likePost(Model model, @RequestParam("postId") long id, @RequestParam("action") String action,
			HttpServletRequest request) {
		Post post = postService.findById(id);

		HttpSession session = request.getSession();
		HashMap<Long, Post> posts = new HashMap<Long, Post>();
		switch (action) {
		case "like":
			if (session.getAttribute("ILiking") == null) {
				post.setLikes(post.getLikes() + 1);
				posts.put(id, post);
			} else {
				posts = (HashMap<Long, Post>) session.getAttribute("ILiking");
				if (posts.containsKey(id)) {
					post.setLikes(post.getLikes() - 1);
					posts.remove(id);
					if (posts.size() == 0) {
						posts = null;
					}
				} else {
					post.setLikes(post.getLikes() + 1);
					posts.put(id, post);
				}
			}
			postService.save(post);
			break;
		case "dislike":
			if (session.getAttribute("ILiking") == null) {
				post.setDislikes(post.getDislikes() + 1);
				posts.put(id, post);
			} else {
				posts = (HashMap<Long, Post>) session.getAttribute("ILiking");
				if (posts.containsKey(id)) {
					post.setDislikes(post.getDislikes() + 1);
					posts.remove(id);
					if (posts.size() == 0) {
						posts = null;
					}
				} else {
					post.setDislikes(post.getDislikes() + 1);
					posts.put(id, post);
				}

			}
			postService.save(post);
			break;
		}
		session.setAttribute("ILiking", posts);

		return "redirect:/home/";
	}
}
