package com.edu.phuxuan.k17.paging.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.phuxuan.k17.paging.entity.Customer;
import com.edu.phuxuan.k17.paging.entity.Province;

public interface CustomerPageRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, org.springframework.data.domain.Pageable pageable);
}

