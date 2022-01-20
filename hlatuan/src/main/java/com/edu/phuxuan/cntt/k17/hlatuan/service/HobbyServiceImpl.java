package com.edu.phuxuan.cntt.k17.hlatuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.phuxuan.cntt.k17.hlatuan.entity.Hobby;
import com.edu.phuxuan.cntt.k17.hlatuan.repository.HobbyRepository;


@Service
public class HobbyServiceImpl implements BaseService<Hobby> {
	
	@Autowired
	private HobbyRepository hobbyRepository;

	@Override
	public List<Hobby> getAll() {
		// TODO Auto-generated method stub
		return hobbyRepository.findAll();
	}

	@Override
	public void save(Hobby object) {
		// TODO Auto-generated method stub
		hobbyRepository.save(object);
	}

	@Override
	public Hobby getByID(int id) {
		// TODO Auto-generated method stub
		return hobbyRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		hobbyRepository.deleteById(id);
	}

	

	

}
