package com.mcnc.security;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	public Authentication authenticate( Authentication arg0 ) throws AuthenticationException {
		
		String userId = arg0.getName().toLowerCase();
		String password = arg0.getCredentials().toString();
		
		if( !"".equalsIgnoreCase( userId ) ){ 
			List< GrantedAuthority > authorities = new ArrayList<GrantedAuthority>();
		    authorities.add(new SwitchUserGrantedAuthority( "ROLE_USER", arg0 ) );
		    
		    // add custom principle
		    UserDetails principal = new User( userId, password, authorities);
		    return new UsernamePasswordAuthenticationToken(principal, password, authorities);
		    
		    // add userId as principle object
		    //return new UsernamePasswordAuthenticationToken( userId, password, authorities );
		}else{
			return null;
		}
		
	}

	public boolean supports(Class<? extends Object> arg0) {
		 return arg0.equals( UsernamePasswordAuthenticationToken.class );
		 
	}

}
