package com.mcnc.security.persistent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPersistentTokenDAO {
	private Map<String, PersistentRememberMeToken> tokens = 
			new HashMap<String, PersistentRememberMeToken>();
	
	
	public void save(PersistentRememberMeToken token) {
		tokens.put(token.getSeries(), token);
	}
	

    public PersistentRememberMeToken findBySeries(String seriesId) {
    	return tokens.get(seriesId);
    }
    
    public List<PersistentRememberMeToken> findByUsername(String username) {
    	List<PersistentRememberMeToken> tokens = new ArrayList<PersistentRememberMeToken>();
    	
    	Set<Entry<String,PersistentRememberMeToken>> entrySet = this.tokens.entrySet();
    	for (Entry<String, PersistentRememberMeToken> entry : entrySet) {
    		if(entry.getValue().getUsername().equalsIgnoreCase(username)) {
    			tokens.add(entry.getValue());
    		}
		}
    	
    	return tokens;
    }

    public void delete(String username) {
    	List<PersistentRememberMeToken> tokens = this.findByUsername(username);
    	if(tokens != null) {
    		for (PersistentRememberMeToken token : tokens) {
				this.tokens.remove(token.getSeries());
			}
    	}
    }
}
