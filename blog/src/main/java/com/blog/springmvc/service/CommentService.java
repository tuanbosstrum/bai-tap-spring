package com.blog.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.blog.springmvc.entity.Comment;
import com.blog.springmvc.repository.CommentRepository;

@Service
public class CommentService implements IService<Comment> {

	@Autowired
	private CommentRepository repo;
	
	@Override
	public List<Comment> findAll() {
		
		return repo.findAll();
	}

	@Override
	public boolean save(Comment object) {
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
		
	}

	@Override
	public Comment findById(long id) {
	
		return null;
	}

	@Override
	public Comment findByObject(Comment object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findByAllObjectId(long id) {
	
		return repo.getCommentsByPost(id);
	}

	@Override
	public Page<Comment> findPage(int num, String field, String dir) {
		// TODO Auto-generated method stub
		return null;
	}



}
