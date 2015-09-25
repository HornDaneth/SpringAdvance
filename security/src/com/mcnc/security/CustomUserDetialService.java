package com.mcnc.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetialService implements UserDetailsService {

	public UserDetails loadUserByUsername( String userName )
			throws UsernameNotFoundException {
		
		
		List< GrantedAuthority > AUTHORITIES = new ArrayList<GrantedAuthority>();
	    AUTHORITIES.add( new SimpleGrantedAuthority( "ROLE_USER" ) );
	    
		UserDetails user = new User( "admin", "admin", AUTHORITIES);
		
		return user;
	}

}
