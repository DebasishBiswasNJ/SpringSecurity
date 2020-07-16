package com.way2learnonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	
//  TODO-4  uncomment the below  to configure AuthenticationManagerBuilder and AuthenticationManager as bean
		
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("siva").password(passwordEncoder.encode("secret"))
			.roles("USER");
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	// TODO-9  uncomment the below method so that it matches /oauth/authorize and any request to /oauth/authorize to be authenticated.
	// we dont want security for login page. so, below configuration is permitting any requests to /login

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	
		http
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		
		.antMatchers("/oauth/authorize")
			.authenticated()
			.and().formLogin()
		.and().requestMatchers()
        	.antMatchers("/login","/oauth/authorize");	
			

	}

	
	
	
	
	
	

	
	
	
}