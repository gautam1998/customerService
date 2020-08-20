package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, String>{
	Optional<Customer> findByCustomerName(String name);
}
