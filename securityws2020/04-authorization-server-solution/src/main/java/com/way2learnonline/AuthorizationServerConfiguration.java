	package com.way2learnonline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;


@Configuration
// TODO-1 Uncomment the below annotation to enable the configurations for Oauth Server endpoints 
//and also their security Configurations
@EnableAuthorizationServer

// TODO-2 Make the below call to extend AuthorizationServerConfigurerAdapter
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter 
{
	/*
	@Autowired
	private  PasswordEncoder encoder;	

	
	*/
	
	

	// TODO-5 uncomment the below method to permit all requests to check token.
	// Now restart the application , get a new token and try to check token

	@Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
       
		oauthServer.tokenKeyAccess("isAuthenticated()")
        	 .checkTokenAccess("isAuthenticated()")              
            ;
        
    }
    
	
	
	// TODO-3 Uncomment the below to Configure Client Details 
	
	
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("way2learnappclientid")
				.authorizedGrantTypes("password","authorization_code")
				.secret(encoder().encode("secret"))
				.scopes("user_info","read","write")
				.redirectUris("https://localhost:8443/myapp/login/oauth2/code/way2learnappclient")
				.autoApprove(false)
				.and()
				.withClient("microclient")
				.authorizedGrantTypes("password","authorization_code","client_credentials")
				.secret(encoder().encode("secret"))
				.scopes("user_info")
				.redirectUris("https://localhost:8443/myapp/login/oauth2/code/way2learnappclient")
				.autoApprove(false)
							;
	}
	
	
	// TODO-4 uncomment the below to inject authentication manager into authorization server endpoints
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		
		// TODO-7 uncomment the below to inject tokenstore() and accessTokenConverter() into AuthorizationServerEndpointsConfigurer
		
			.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter());
		;
	}
	
	
	//TODO-6  Uncomment the below to enable JWT tokens
	
	
	
	 @Bean
	    public TokenStore tokenStore() {
	        return new JwtTokenStore(accessTokenConverter());
	    }

	    @Bean
	    public JwtAccessTokenConverter accessTokenConverter() {
	        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	        //converter.setSigningKey("123");
	        final KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
	        		new ClassPathResource("mykeystore.jks"), "password".toCharArray());
	         converter.setKeyPair(keyStoreKeyFactory.getKeyPair("tomcat"));
	        return converter;
	    }
	    
	    
	    
	    
	
	@Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
	
}
