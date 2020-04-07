package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Thats It....Thanks to this....saved my day.
	
	//We will automatically get methods : findAll(), findById(), deleteById()
	
	// Add a methods to sort by last name
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
