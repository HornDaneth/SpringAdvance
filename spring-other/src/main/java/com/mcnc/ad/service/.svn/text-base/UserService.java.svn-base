package com.mcnc.ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import com.mcnc.ad.dto.User;
import com.mcnc.ad.mapper.UserAttributesMapper;


public class UserService{
	@Autowired LdapTemplate ldapTemplate;
	
	private String searchBase;

	public String getSearchBase() {
		return searchBase;
	}


	public void setSearchBase(String searchBase) {
		this.searchBase = searchBase;
	}


	public List< User > getAllUsers(){
       return ldapTemplate.search( getSearchBase(), "(objectClass=person)", new UserAttributesMapper());
    }
	
	
	 public boolean authenticate( String userName, String password ) {
		 AndFilter filter = new AndFilter();
         filter.and(new EqualsFilter("objectclass", "person")).and(
                 new EqualsFilter("sAMAccountName", userName));
         System.out.println( filter.toString());
         boolean result=  ldapTemplate.authenticate( getSearchBase(), filter.toString(), password);
        
         return result;
	 }

	
}
