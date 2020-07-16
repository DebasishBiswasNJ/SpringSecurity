package com.way2learnonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.way2learnonline.events.UserRegistrationEvent;


@Service

public class EmailVerificationListener implements ApplicationListener<UserRegistrationEvent> {

	@Autowired
	private  JavaMailSender mailSender;
	@Autowired
	private VerificationService verificationService;
	
	
	
	@Override
	public void onApplicationEvent(UserRegistrationEvent event) {
	
		String username = event.getUser().getUsername();
		Long verificationId = verificationService.createVerification(username);		
		String email = event.getUser().getEmail();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("SivaApp Account Verification");
		message.setText("Account activation link: https://localhost:8443/myapp/verify/email?id="+verificationId);
		message.setTo(email);
		mailSender.send(message);
		
		
		System.err.println("**************Mail Sentttttttttttttttt");
	}

}
