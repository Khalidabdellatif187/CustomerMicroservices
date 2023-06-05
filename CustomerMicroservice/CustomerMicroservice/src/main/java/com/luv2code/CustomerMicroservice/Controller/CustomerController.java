package com.luv2code.CustomerMicroservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.CustomerMicroservice.Entity.Customer;
import com.luv2code.CustomerMicroservice.Service.CustomerService;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	
	
	private CustomerService service;

	
	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/customer/save")
	
	public ResponseEntity<Customer> create(@RequestBody Customer customer){
		
		return new ResponseEntity<>(service.saveCustomer(customer) , HttpStatus.CREATED);
	}
	
	
	@GetMapping("/customers")
	public List<Customer> getPlots(){
		
		return service.getCustomers();
	}
	
	
	
	
	
	
}
