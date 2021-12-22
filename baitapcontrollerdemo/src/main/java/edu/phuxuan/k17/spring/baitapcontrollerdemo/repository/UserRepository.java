package edu.phuxuan.k17.spring.baitapcontrollerdemo.repository;

import java.util.List;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.User;

public interface UserRepository {

	public List<User> findAll();
	public User findUserById(int id);
	public boolean checkLogin(User user);
	public void register(User user);
}
