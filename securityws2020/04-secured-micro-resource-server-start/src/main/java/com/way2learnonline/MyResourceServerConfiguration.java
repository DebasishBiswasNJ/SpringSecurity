package com.way2learnonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;


@Configuration
// TODO-1 uncomment the below annotation which will configure all the 
//filters required on the resource server
@EnableResourceServer

//TODO-2 uncomment the below annotation as we want to use method level annotations also

@EnableGlobalMethodSecurity(prePostEnabled = true)

// TODO-3 make the below class to extend ResourceServerConfigurerAdapter
public class MyResourceServerConfiguration extends ResourceServerConfigurerAdapter
	{
	
	
	// TODO-4 uncomment the below to configure such that all request coming to this resource server should be fully authenticated
		
	@Override 
    public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").fullyAuthenticated();
	
    }
	
	

	// TODO-6 uncomment the below to give the reference of remotetokenservices to ResourceServerSecurityConfigurer
	
	
	/* 
	 	@Autowired
	private RemoteTokenServices tokenServices;
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		
	
		resources.tokenServices(tokenServices);
		
	}
	*/
	
	
	
	
	

}
