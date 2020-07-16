package com.way2learnonline.repository;

import org.springframework.data.repository.CrudRepository;

import com.way2learnonline.model.MyAppUser;

public interface UserRepository extends CrudRepository<MyAppUser, String> {

	MyAppUser findByUsername(String username);
	MyAppUser findByEmail(String email);
	
}
