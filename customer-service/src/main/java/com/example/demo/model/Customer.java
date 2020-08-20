package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "account_balance")
	private double accountBalance;
	public Customer() {
		super();
	}
	public Customer(String customerId, String customerName, double accountBalance) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
