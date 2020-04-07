package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//Autowiring :Constructor Based 
	private EmployeeService empService;
	
	
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}

// To get the list of employees
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get the employees from db
		List<Employee> theEmployees = empService.findAll();
		
		theModel.addAttribute("employeeList",theEmployees);
		
		return "list-employees";
	}
	
// To show the form for adding a new employee
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
	
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee",theEmployee);

		return "employee-form";
	}
	
//To add a new employee
	
	@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
	
		empService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	// To show the form for update employee 
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("employeeId") int theId,
										Model theModel) {
		
			Employee theEmployee = empService.findById(theId);
			
			theModel.addAttribute("employee",theEmployee);

			return "employee-form";
		}	
		
		@GetMapping("/delete")
		public String delete(@RequestParam("employeeId") int theId) {
			
			empService.deleteById(theId);
			
			return "redirect:/employees/list";
		}
}
