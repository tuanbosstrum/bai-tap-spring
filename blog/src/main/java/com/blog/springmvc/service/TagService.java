package com.blog.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.blog.springmvc.entity.Tag;
import com.blog.springmvc.repository.TagRepository;

@Service
public class TagService implements IService<Tag> {

	@Autowired
	private TagRepository repo;

	@Override
	public List<Tag> findAll() {
		try {

			return repo.findAll();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Tag object) {
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
	public Tag findById(long id) {
		try {
			return repo.findById(id).get();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
		
	}

	@Override
	public Tag findByObject(Tag object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> findByAllObjectId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Tag> findPage(int num, String field, String dir) {
		// TODO Auto-generated method stub
		return null;
	}

}
