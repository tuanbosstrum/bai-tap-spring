package edu.phuxuan.k17.spring.baitapcontrollerdemo.services;

import java.util.List;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.User;


public interface UserService {

	public List<User> findAll();
	public User findUserById(int id);
	public boolean checkLogin(User user);
	public void register(User user);
}
