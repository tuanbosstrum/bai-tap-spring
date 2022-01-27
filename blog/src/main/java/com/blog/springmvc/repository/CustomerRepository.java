package com.blog.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.springmvc.entity.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE c.username=?1 AND c.password =?2 ")
	Customer checkLogin(String username, String password);
}
