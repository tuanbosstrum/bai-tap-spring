package com.blog.springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletContext;

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
import org.springframework.web.multipart.MultipartFile;

import com.blog.springmvc.core.Render;
import com.blog.springmvc.entity.Customer;
import com.blog.springmvc.entity.Post;
import com.blog.springmvc.entity.Tag;
import com.blog.springmvc.service.IService;

@Controller
@RequestMapping("/post")
public class PostController extends Render {
	
	@Autowired
	ServletContext context;
	@Autowired
	private IService<Post> postService;
	@Autowired
	private IService<Tag> tagService;
	
	@GetMapping("/")
	public String viewIndex(Model model) {
		
		return viewIndexHome(model, 1, "id", "asc");
	}
	@GetMapping("/page")
	public String viewIndexHome(Model model ,@RequestParam("num") int num, @RequestParam("field") String field, @RequestParam("dir") String dir) {
		SetPage(model, "Trang chủ", "fragments/post/list");
		model.addAttribute("currentPage", num);
		model.addAttribute("field", field);
		model.addAttribute("dir", dir);
		model.addAttribute("reverseSortDir", dir.equals("asc") ? "desc" : "asc");
		model.addAttribute("tags", tagService.findAll());
		model.addAttribute("posts", postService.findPage(num, field, dir));
		model.addAttribute("tags", tagService.findAll());
		return View();
	}
	@GetMapping("/list")
	public String viewList(Model model) {
		SetPage(model, "Danh sách bài viết", "fragments/post/list");
		model.addAttribute("posts", postService.findAll());
		model.addAttribute("tags", tagService.findAll());
		return View();
	}
	@GetMapping("/form")
	public String viewCreateForm(Model model) {
		SetPage(model, "Bài viết", "fragments/post/form");
		model.addAttribute("post", new Post());
		model.addAttribute("tags", tagService.findAll());
		return View();
	}
	@PostMapping("/save")
	public String submitCreate( @ModelAttribute("post") Post post ,@SessionAttribute("setCustomer") Customer customer,@RequestParam("photo") MultipartFile photo) {
		post.setAuth(customer);
		String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
		post.setImage(fileName);
		if(postService.save(post) == true) {
			String uploadDir = context.getRealPath("resources/uploads/post"); // SERVER PATH
			//String uploadDir = "C:\\Users\\Admin\\eclipse-workspace\\blog\\src\\main\\webapp\\resources\\uploads\\post"; // Local path
			try {
				saveFile(uploadDir, fileName, photo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/home/";
		}
		return "redirect:form";
	}
}
