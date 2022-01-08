package edu.phuxuan.k17.spring.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.phuxuan.k17.spring.jpa.entity.Hobby;
import edu.phuxuan.k17.spring.jpa.service.BaseService;



@Controller
@RequestMapping("/hobby")
public class HobbyController {

	@Autowired
	private BaseService<Hobby> hobbyService;
	@GetMapping("/list")
	public String listHobbys(Model theModel) {
		List<Hobby> theHobbys = hobbyService.getAll();
		theModel.addAttribute("hobbys", theHobbys);
	
		
		return "list-hobbys";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		//LOG.debug("inside show customer-form handler method");
		Hobby theHobby = new Hobby();
		theModel.addAttribute("hobby", theHobby);
		
		return "hobby-form";
	}
	
	@PostMapping("/saveHobby")
	public String saveHobby(@Valid @ModelAttribute("hobby") Hobby theHobby , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
    		
			return  "hobby-form"; 
		
		}else {
			hobbyService.save(theHobby);	
			return "redirect:/hobby/list";
		}
		
	}
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("hobbyId") int theId,
									Model theModel)  {
		Hobby theHobby = hobbyService.getByID(theId);	
		theModel.addAttribute("hobby", theHobby);
		return "hobby-form";
	}
	
	@GetMapping("/delete")
	public String deleteHobby(@RequestParam("hobbyId") int theId)  {
		hobbyService.deleteById(theId);
		return "redirect:/hobby/list";
	}
}
