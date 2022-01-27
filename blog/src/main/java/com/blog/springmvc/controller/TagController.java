package com.blog.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.springmvc.core.Render;
import com.blog.springmvc.entity.Tag;
import com.blog.springmvc.service.IService;

@Controller
@RequestMapping("/tag")
public class TagController extends Render {

	@Autowired
	private IService<Tag> service;
	
	@GetMapping("/list")
	public String viewTags(Model model) {
		SetPage(model, "Danh sách Tag", "fragments/tag/list");
		model.addAttribute("tags", service.findAll());
		return View();
	}
	@GetMapping("/create")
	public String viewCreateForm(Model model) {
		SetPage(model, "Thêm mới", "fragments/tag/form");
		model.addAttribute("tag", new Tag());
		return View();
	}
	@GetMapping("/update")
	public String viewUpdateForm(Model model, @RequestParam("id") long id) {
		SetPage(model, "Cập nhật", "fragments/tag/form");
		model.addAttribute("tag", service.findById(id));
		return View();
	}
	@PostMapping("/save")
	public String submitForm( @ModelAttribute(name ="tag") Tag tag) {
		service.save(tag);
		return "redirect:list";
	}
}
