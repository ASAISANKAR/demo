package com.klef.jfsd.springboot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CustomerRepository;

@Service
public class AdminServiceImplementation implements AdminService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<Customer> viewAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Admin checkAdminLogin(String username, String password) {
	  return adminRepository.checkAdminLogin(username, password);
	}

	@Override
	public long customercount() {
		return customerRepository.count();
	}

}
