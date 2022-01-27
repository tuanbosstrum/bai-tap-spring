package com.blog.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.springmvc.entity.Post;
import com.blog.springmvc.repository.PostRepository;

@Service
public class PostService implements IService<Post> {

	@Autowired
	private PostRepository repo;
	
	@Override
	public List<Post> findAll() {
		try {

			return repo.findAll();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(Post object) {
//		try {
//
//			repo.save(object);
//			return true; 
//		} catch (Exception e) {
//			e.getStackTrace();
//			return false;
//		}
		repo.save(object);
		return true;
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
	public Post findById(long id) {
		try {

			return repo.findById(id).get();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public Post findByObject(Post object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findByAllObjectId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Post> findPage(int num, String field, String dir) {
		Pageable pageable = PageRequest.of(num - 1, 6,dir.equals("asc") ? Sort.by(field).ascending(): Sort.by(field).descending());
		return repo.findAll(pageable);
	}

}
