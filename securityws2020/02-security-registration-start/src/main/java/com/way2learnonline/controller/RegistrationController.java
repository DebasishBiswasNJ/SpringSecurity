package com.way2learnonline.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.way2learnonline.events.UserRegistrationEvent;
import com.way2learnonline.model.MyAppUser;
import com.way2learnonline.model.UserDto;
import com.way2learnonline.service.UserRegistrationService;



@Controller

public class RegistrationController {
	
	@Autowired
	private  UserRegistrationService service;
	
	//TODO-15 Uncomment the below to autowire ApplicationEventPublisher
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private  PasswordEncoder encoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user",new UserDto());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") UserDto user, BindingResult result) {
		if(result.hasErrors()) {
			return "register";
		}
		
		//TODO-16 In the below MyAppUser Constructor call, make the last parameter as false to disable the user

		
		MyAppUser myuser = new MyAppUser(user.getUsername(), 
				  user.getFirstname(), 
				  user.getLastname(),
				  user.getEmail(), 
				  encoder.encode(user.getPassword()), false);
		service.createUser(myuser);
		
		//TODO-17 uncomment the below line to publish UserRegistrationEvent
		
		eventPublisher.publishEvent(new UserRegistrationEvent(myuser));
		return "redirect:register?success";
	}
	
}
