package edu.phuxuan.k17.spring.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.phuxuan.k17.spring.mvcdemo.model.Student;
@Controller
public class myHomeController {
	
//	@RequestMapping("/home")
//	public String home() {
//		return "home";
//	}
	@RequestMapping({"/home"})
	public String Home(Model model) {
		Student std = new Student();
		std.setFullname("Hoàng Anh Tuan");
		model.addAttribute("student", std);
		return "home";
	}
}