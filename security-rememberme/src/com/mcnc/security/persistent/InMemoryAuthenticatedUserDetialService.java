package com.mcnc.security.persistent;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class InMemoryAuthenticatedUserDetialService implements UserDetailsService {
	
	private Map<String, UserDetails> users = new HashMap<String, UserDetails>();

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		/*List< GrantedAuthority > AUTHORITIES = new ArrayList<GrantedAuthority>();
	    AUTHORITIES.add( new SimpleGrantedAuthority( "ROLE_USER" ) );
	    
		
		
		return user;*/
		UserDetails userDetails = users.get(username);
		if(userDetails != null) {
			return  userDetails;
		}
		else {
			throw new UsernameNotFoundException("User Not found");
		}
	}
	
	public void save( String username, List< GrantedAuthority > authorities) {
		UserDetails user = new User( username, "", authorities);
		this.users.put(username, user);
	}
	
	public void save( String username, Collection< ? extends GrantedAuthority > authorities) {
		UserDetails user = new User( username, "", authorities);
		this.users.put(username, user);
	}
	
	public void delete(String username) {
		this.users.remove(username);
	}

}
