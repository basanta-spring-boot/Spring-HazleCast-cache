package com.basant.hazlecast.cache.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basant.hazlecast.cache.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
