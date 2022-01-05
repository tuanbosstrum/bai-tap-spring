package edu.phuxuan.k17.spring.demojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.phuxuan.k17.spring.demojpa.entity.Customer;
import edu.phuxuan.k17.spring.demojpa.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.findAll();
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer, BindingResult thebindingResult) {
		if (thebindingResult.hasErrors()) {
			return "customer-form";
		}
		customerService.save(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.findById(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.remove(theId);
		return "redirect:/customer/list";
	}
}
