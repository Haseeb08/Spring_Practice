package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	// Autowiring : using field.
	@Autowired
	private EmployeeRepository empRepo;

    
	// Returning list of all employees,sorted by last name. 
	@Override
	public List<Employee> findAll() {
		return empRepo.findAllByOrderByLastNameAsc();
	}

	
	// Finding a particular employee with provided employee Id.
	// Optional object type is used to deal will null : if no employee is found with that Id.
	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = empRepo.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent())
		{
			theEmployee = result.get();
		}
		else
			throw new RuntimeException("Employee ID not found :"+theId);
		return theEmployee;
	}

	// Saving the employee in db.
	@Override
	public void save(Employee theEmp) {
		empRepo.save(theEmp);
	}

	// Deleting the employee from db.
	@Override
	public void deleteById(int theId) {
		empRepo.deleteById(theId);
	}

}
