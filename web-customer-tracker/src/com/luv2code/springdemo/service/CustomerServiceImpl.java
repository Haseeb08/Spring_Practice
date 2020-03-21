package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO cd;

	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return cd.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer c) {
		cd.saveCustomer(c);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return cd.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		cd.deleteCustomer(id);
		
	}
	
	
	
	
	
	

	
}
