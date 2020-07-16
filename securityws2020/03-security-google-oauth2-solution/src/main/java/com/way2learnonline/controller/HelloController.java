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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class HelloController {
	


	@Autowired
	private WebClient webClient;
	
	@GetMapping("/hello")
	public @ResponseBody String sayHello(Model model, @RequestParam(defaultValue = "Siva" ,required = false)String name) throws Exception {
	
		model.addAttribute("name", name);
		
		//String response=webClient.get().uri(new URI("http://localhost:9999/hello")).retrieve().bodyToMono(String.class).block();
		//System.out.println("Got response from resource server : "+ response);
		
		//return response;
		
		return "Hello ";
	}
	
	
	@GetMapping("/home")
	public String home() {
		return "hello";
	}

}
