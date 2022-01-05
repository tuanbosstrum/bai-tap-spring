package edu.phuxuan.k17.spring.demojpa.dao;

import java.util.List;

import edu.phuxuan.k17.spring.demojpa.entity.Customer;


public interface CustomerReponsitory {
	List<Customer> findAll();

	Customer findById(int id);

	void save(Customer customer);

	void remove(int id);
}
