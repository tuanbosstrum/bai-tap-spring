package com.edu.phuxuan.k17.paging.service.define;

import org.springframework.data.domain.Pageable;

import com.edu.phuxuan.k17.paging.entity.Customer;
import com.edu.phuxuan.k17.paging.entity.Province;

import org.springframework.data.domain.Page;


public interface CustomerPageService {
	
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}

