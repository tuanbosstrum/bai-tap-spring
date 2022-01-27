package com.blog.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IService <T> {
	
	List<T> findAll();
	boolean save(T object);
	void remove(long id);
	T findById(long id);
	T findByObject(T object);
	List<T> findByAllObjectId(long id);
	Page<T> findPage(int num , String field , String dir);
}
