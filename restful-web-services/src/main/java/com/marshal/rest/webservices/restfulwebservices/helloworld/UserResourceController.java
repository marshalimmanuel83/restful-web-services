package com.marshal.rest.webservices.restfulwebservices.helloworld;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marshal.rest.webservices.restfulwebservices.user.User;
import com.marshal.rest.webservices.restfulwebservices.user.UserDAOService;

@RestController
public class UserResourceController {
	
	@Autowired
	UserDAOService daoService;
	
	@GetMapping(path="/users")
	public List<User> findAllUsers() {
		return daoService.findAllUsers();
	}
	
	@GetMapping(path="/users/{id}")
	public User getUserById(@PathVariable int id) {
		User user = daoService.getUserById(id);
		if (user == null) {
			throw new UserNotFoundException("Id:- " + id);
		}
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser = daoService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		daoService.deleteUserById(id);
	}

}
