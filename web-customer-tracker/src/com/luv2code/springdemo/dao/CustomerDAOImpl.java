package com.luv2code.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	//Inject SessionFactory
	
	@Autowired
	private SessionFactory fac;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session currSession = fac.getCurrentSession();
		
		Query<Customer> q= currSession.createQuery("from Customer order by lastName",
													Customer.class);
		
		List<Customer> customers= q.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer c) {
	
		Session currSession = fac.getCurrentSession();
		
		
		currSession.saveOrUpdate(c);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session currSession = fac.getCurrentSession();
		Customer c;
		c=currSession.get(Customer.class,id);
		return c;
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session currSession = fac.getCurrentSession();
		Customer c;
		c=currSession.get(Customer.class,id);
		currSession.delete(c);

	}

}
