package com.luv2code.CustomerMicroservice.Service;

import java.util.List;

import com.luv2code.CustomerMicroservice.Entity.Customer;

public interface CustomerService {
	
    public Customer saveCustomer(Customer customer);
	
	public List<Customer> getCustomers();
	
	

}
