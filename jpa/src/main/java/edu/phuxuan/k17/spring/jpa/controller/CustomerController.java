package edu.phuxuan.k17.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.phuxuan.k17.spring.jpa.entity.Customer;
import edu.phuxuan.k17.spring.jpa.entity.Hobby;
import edu.phuxuan.k17.spring.jpa.entity.Province;
import edu.phuxuan.k17.spring.jpa.service.BaseService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private BaseService<Customer> customerService;
	
	@Autowired
    private BaseService<Province> provinceService;
	
	@Autowired
	private BaseService<Hobby> hobbyService;
	
	@ModelAttribute("provinces")
	public List<Province> provinces(){
	        return provinceService.getAll();
	}
	
	@ModelAttribute("hobbies")
	public List<Hobby> hobbies(){
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
		//LOG.debug("inside show customer-form handler method");
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
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel)  {
		Customer theCustomer = customerService.getByID(theId);	
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)  {
		customerService.deleteById(theId);
		return "redirect:/customer/list";
	}
}
