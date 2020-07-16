package com.way2learnonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	//TODO-5 uncomment the below to configure RemoteTokenServices bean which will be used to verify the tokens
	
	/*
	@Bean
	public RemoteTokenServices tokenService(){
		RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl("http://localhost:8081/auth/oauth/check_token");
		tokenService.setClientId("microclient");
		tokenService.setClientSecret("secret");
		
		return tokenService;
	}
	
	*/

}
