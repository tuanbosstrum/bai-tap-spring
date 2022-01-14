package com.edu.phuxuan.k17.paging.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.phuxuan.k17.paging.entity.Customer;
import com.edu.phuxuan.k17.paging.entity.Hobby;
import com.edu.phuxuan.k17.paging.entity.Province;
import com.edu.phuxuan.k17.paging.service.define.BaseService;
import com.edu.phuxuan.k17.paging.service.define.CustomerPageService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private BaseService<Customer> customerService;

	@Autowired
	private BaseService<Province> provinceService;

	@Autowired
	private BaseService<Hobby> hobbyService;
	
	
	@Autowired
	private CustomerPageService customerPageService;
	

	@ModelAttribute("provinces")
	public List<Province> provinces() {
		return provinceService.getAll();
	}

	@ModelAttribute("hobbies")
	public List<Hobby> hobbies() {
		return hobbyService.getAll();
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.getAll();
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		// LOG.debug("inside show customer-form handler method");
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.save(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.getByID(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteById(theId);
		return "redirect:/customer/list";
	}

	@GetMapping("/page2")
	public ModelAndView listCustomers2(@RequestParam("s") Optional<String> s, Pageable pageable) {
		Page<Customer> customers;
		if (s.isPresent()) {
			customers = customerPageService.findAllByFirstNameContaining(s.get(), pageable);
		} else {
			customers = customerPageService.findAll(pageable);
		}
		ModelAndView modelAndView = new ModelAndView("list-customers-page");
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}
	
	@GetMapping("/page")
	public String listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable,  Model theModel) {
		Page<Customer> customers;
		if (s.isPresent()) {
			customers = customerPageService.findAllByFirstNameContaining(s.get(), pageable);
		} else {
			customers = customerPageService.findAll(pageable);
		}
		theModel.addAttribute("customers", customers);

		return "list-customers-page";
	}
	
}
