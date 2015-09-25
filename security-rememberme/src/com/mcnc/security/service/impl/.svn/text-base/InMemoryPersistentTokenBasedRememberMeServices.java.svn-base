package com.mcnc.security.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.mcnc.security.persistent.InMemoryAuthenticatedUserDetialService;

public class InMemoryPersistentTokenBasedRememberMeServices extends PersistentTokenBasedRememberMeServices {
	
	InMemoryAuthenticatedUserDetialService inMemoryUserDetailService;
	 
	public InMemoryPersistentTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService,
             PersistentTokenRepository tokenRepository) {
		super(key, userDetailsService, tokenRepository);
		
		Assert.assertTrue(userDetailsService instanceof InMemoryAuthenticatedUserDetialService);
		inMemoryUserDetailService = 
				(InMemoryAuthenticatedUserDetialService) getUserDetailsService();
	}
	
	@Override
	protected void onLoginSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication successfulAuthentication) {
		
		// save to In-Memory user detail
		inMemoryUserDetailService.save(successfulAuthentication.getName(), 
				successfulAuthentication.getAuthorities());
		
		super.onLoginSuccess(request, response, successfulAuthentication);
	}
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		// remove from In-Memory user detail
		inMemoryUserDetailService.delete(authentication.getName());
		
		super.logout(request, response, authentication);
	}
	
}
