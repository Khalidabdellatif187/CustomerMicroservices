package com.luv2code.CustomerMicroservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.CustomerMicroservice.Entity.Customer;
import com.luv2code.CustomerMicroservice.Repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	
	
	private CustomerRepository repo;
	
	private RestTemplate restTemplate;
	
	
	
    @Autowired
    public CustomerServiceImpl(CustomerRepository repo, RestTemplate restTemplate) {
		super();
		this.repo = repo;
		this.restTemplate = restTemplate;
	}

	public CustomerServiceImpl() {
		
	}

	@Override
	public List<Customer> getCustomers() {
		
		List<Customer> customers = repo.findAll();
		
		return customers;
		
	}

	

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer customer1 = new Customer();
		
		customer1.setId(customer.getId());
		customer1.setFirstName(customer.getFirstName());
		customer1.setLastName(customer.getLastName());
		customer1.setEmail(customer.getEmail());
		
		
		
		repo.saveAndFlush(customer1);
		
		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}", 
				FraudCheckResponse.class
				,customer1.getId());
		
		
		if(fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("fraudster");
		}
		return customer1;
		
	}
	
	

	
	
	
	
}
