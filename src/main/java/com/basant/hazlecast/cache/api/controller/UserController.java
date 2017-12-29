package com.basant.hazlecast.cache.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basant.hazlecast.cache.api.model.User;
import com.basant.hazlecast.cache.api.service.UserService;

@RestController
@RequestMapping("/hazlecast-cache")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		return service.getUsers();
	}

	@GetMapping("/findById/{id}")
	public User findUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable int id, @RequestParam("address") String address) {
		return service.updateUser(id, address);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

}
