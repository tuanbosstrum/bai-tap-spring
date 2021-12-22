package edu.phuxuan.k17.spring.baitapcontrollerdemo.repository;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.User;


public class UserRepositoryImpl implements UserRepository {
	private static final Map<Integer, User> users;
	static {
		users = new HashMap<Integer, User>();
		users.put(1, new User("admin","123456"));
		users.put(2, new User("staff","123456"));
	}
	public User findUserById(int id) {
		User user = users.get(id);
		return user;
	}



	public boolean checkLogin(User user) {
		boolean isUser = false;
		for (User u : findAll()) {
			if(!u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				isUser = true;
			}else {
				isUser = false;
			}
		}
		return isUser;
		
	}
	public List<User> findAll() {
		
		return new ArrayList<User>(users.values());
	}
	public void register(User user) {
		int randomId = (int)(Math.random() * 10000);
		users.put(randomId, user);
	
	}

}
