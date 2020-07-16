package com.way2learnonline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHello(@RequestParam(required = false,defaultValue = "Sivaa") String name) {
		return "Hello "+name;
	}
	
	@GetMapping("/admin/hello")
	public String sayAdminHello(@RequestParam(required = false,defaultValue = "Sivaa")String name) {
		return "Hello Admin "+name;
	}

}
