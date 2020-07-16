package com.way2learnonline.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.way2learnonline.model.MyAppUser;

import com.way2learnonline.repository.UserRepository;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private  PasswordEncoder encoder;
	
	@Override
	public void createUser(MyAppUser user) {
		
		userRepository.save(user);
		
		System.out.println("***** User Saved  *****");
	}

	

}