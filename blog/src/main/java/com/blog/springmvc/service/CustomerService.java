package com.blog.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.blog.springmvc.entity.Customer;
import com.blog.springmvc.repository.CustomerRepository;

@Service
public class CustomerService  implements IService<Customer>{

	@Autowired 
	private CustomerRepository repo;
	@Override
	public List<Customer> findAll() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Customer object) {
		try {
			repo.save(object);
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public void remove(long id) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	@Override
	public Customer findById(long id) {
		try {
			return repo.findById(id).get();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	@Override
	public Customer findByObject(Customer object) {
		try {
			return repo.checkLogin(object.getUsername(),object.getPassword());
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Customer> findByAllObjectId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Customer> findPage(int num, String field, String dir) {
		// TODO Auto-generated method stub
		return null;
	}

}
