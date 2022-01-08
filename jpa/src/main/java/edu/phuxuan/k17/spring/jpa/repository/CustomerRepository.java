package edu.phuxuan.k17.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.phuxuan.k17.spring.jpa.entity.Customer;
import edu.phuxuan.k17.spring.jpa.entity.Province;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findAllByProvince(Province province); 
}
