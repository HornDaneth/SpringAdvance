package com.mcnc.security.persistent;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;

@Service("persistentTokenService")
public class PersistentTokenServiceImpl implements PersistentTokenRepository {
	
	@Autowired
	InMemoryPersistentTokenDAO tokenDao;
  
    public void createNewToken(PersistentRememberMeToken token) {
    	tokenDao.save(token);
    }

    public void updateToken(String series, String tokenValue, Date lastUsed) {
    	PersistentRememberMeToken token = tokenDao.findBySeries(series);
        if (token != null){
        	token = new PersistentRememberMeToken(token.getUsername(), series, 
        			tokenValue, lastUsed);
        	tokenDao.save(token);
        }
    }

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
    	return tokenDao.findBySeries(seriesId);
    }

    public void removeUserTokens(String username) {
    	tokenDao.delete(username);
    }
}
