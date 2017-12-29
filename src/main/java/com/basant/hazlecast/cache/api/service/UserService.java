package com.basant.hazlecast.cache.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.basant.hazlecast.cache.api.model.User;
import com.basant.hazlecast.cache.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void loadData2DB() {
		List<User> users = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			users.add(new User(i, "name" + i, "address" + i));
		}
		repository.save(users);
	}

	@Cacheable(cacheNames = { "usersCache" })
	public List<User> getUsers() {
		int tripCount = 0;
		tripCount++;
		System.out.println("Hit DB in request count for getUsers() " + tripCount + " times");
		return repository.findAll();
	}

	@Cacheable(value = "usersCache", key = "#id", unless = "#result==null")
	public User getUserById(int id) {
		int tripCount = 0;
		tripCount++;
		System.out.println("Hit DB in request count for getUserById() " + tripCount + " times");
		return repository.findOne(id);
	}

	@CacheEvict(value = "usersCache", key = "#id")
	public String deleteUser(int id) {
		repository.delete(id);
		return "record deleted with id :" + id;
	}

	@CachePut(value = "usersCache", key = "#id")
	public String updateUser(int id, String address) {
		User user = repository.findOne(id);
		if (user != null) {
			user.setAddress(address);
			repository.save(user);
		}
		return "user address update sucessfully ! id: " + id;

	}
}
