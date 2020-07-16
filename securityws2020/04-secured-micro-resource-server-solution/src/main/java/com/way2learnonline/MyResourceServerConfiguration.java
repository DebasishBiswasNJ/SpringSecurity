package com.way2learnonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.jwt.crypto.sign.SignatureVerifier;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;


@Configuration


@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyResourceServerConfiguration   extends ResourceServerConfigurerAdapter
{
	
	
	//@Autowired
	//private RemoteTokenServices tokenServices;
	
	
	@Override 
    public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").fullyAuthenticated();
	
    }
    
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		
	
		//resources.tokenServices(tokenServices);
		
		//resources.tokenStore(tokenStore());
		
	}
	
	

	
	
	
	
	
	

}
