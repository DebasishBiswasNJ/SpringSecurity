package com.way2learnonline.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class HelloController {
	
	//@Autowired
	//private OAuth2RestTemplate oAuth2RestTemplate;
	
	@Autowired
	private WebClient webClient;
	
	@GetMapping("/hello")
	public String sayHello(Model model, @RequestParam(defaultValue = "Siva" ,required = false)String name) throws Exception, URISyntaxException {
		
		model.addAttribute("name", name);
		String response = webClient.get().uri(new URI("http://localhost:8084/hello")).retrieve().bodyToMono(String.class).block();
		
		//return oAuth2RestTemplate.getForObject(new URI("http://localhost:8084/hello"), String.class);
		//return "hello";
		System.out.println("Got response from Resource Server : "+response);
		return response;
	}
	
	
	@GetMapping("/home")
	public String home() {
		return "hello";
	}

}
