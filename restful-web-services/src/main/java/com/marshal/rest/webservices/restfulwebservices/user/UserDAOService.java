package com.marshal.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	private static ArrayList<User> userList = new ArrayList<>();
	
	private static int userCount = 3;
	
	static {
		userList.add(new User(1, "Marshal", new Date()));
		userList.add(new User(2, "Nancy", new Date()));
		userList.add(new User(3, "Joel", new Date()));
	}
	
	// find all the list of users
	public ArrayList<User> findAllUsers() {
		return userList;
	}
	
	// save a new user
	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}
	
	// retrieve a user for the given id
	public User getUserById(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	// delete an user account based on the given id from client
	public void deleteUserById(int id) {
		for (User user : userList) {
			if (user.getId() != null) {
				userList.remove(user);
			}
		}
	}
}
