package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerContoller {

//	//Inject DAO
//	@Autowired
//	private CustomerDAO cd;
//	
	
	//inject customerservcie
	@Autowired
	private CustomerService cs;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		//get customers from dao
		List<Customer> customers = cs.getCustomers();
		
		//add customers to model
		model.addAttribute("customers",customers);
		
		return "list-customer";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer c = new Customer();
		
		model.addAttribute("customer",c);
		
		return "customer-form";		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer c) {
	
	//save the customer using service
		cs.saveCustomer(c);
		
		return "redirect:/customer/list";	
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		Customer c=cs.getCustomer(id);
		
		model.addAttribute("customer", c);
		
		
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id, Model model) {
		cs.deleteCustomer(id);
		
		return "redirect:/customer/list";
		
	}
}
