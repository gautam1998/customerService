package com.example.demo.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping("/customers")
	public ResponseEntity<Iterable<Customer>> getAllCustomer()
	{
		return new ResponseEntity<Iterable<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	/*
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable("customerId") String customerId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.findCustomerById(customerId));
	}
	*/
	@GetMapping("/customers/{customerName}")
	public ResponseEntity<Optional<Customer>> findCustomerByName(@PathVariable("customerName") String customerName)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.findUserByName(customerName));
	}
	
	@PostMapping("/customers")
	  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	    try {
	      Customer _customers = customerService
	          .save(new Customer(customer.getCustomerId(), customer.getCustomerName(), customer.getAccountBalance()));
	      return new ResponseEntity<>(_customers, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@DeleteMapping("/companies")
	  public ResponseEntity<HttpStatus> deleteCompany() {
	    try {
	      customerService.deleteAllCustomer();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
