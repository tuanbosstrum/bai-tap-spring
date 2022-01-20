package com.edu.phuxuan.cntt.k17.hlatuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.phuxuan.cntt.k17.hlatuan.entity.Customer;
import com.edu.phuxuan.cntt.k17.hlatuan.entity.Province;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findAllByProvince(Province province); 
}
