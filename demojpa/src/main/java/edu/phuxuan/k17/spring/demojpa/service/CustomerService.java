package edu.phuxuan.k17.spring.demojpa.service;

import java.util.List;

import edu.phuxuan.k17.spring.demojpa.entity.Customer;


public interface CustomerService {
	List<Customer> findAll();

	Customer findById(int id);

	void save(Customer customer);

	void remove(int id);
}
