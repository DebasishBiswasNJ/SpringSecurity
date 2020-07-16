package com.way2learnonline;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	@PreAuthorize("#oauth2.hasScope('read')")
    public String helloSecured() {

        return "Hello - Secured";
    }
}
