package com.mcnc.ad.mapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import com.mcnc.ad.dto.User;



public class UserAttributesMapper implements AttributesMapper<User> {
	 
    public User mapFromAttributes(Attributes attributes) throws NamingException {
 
        User userObject = new User();
 
        String commonName = (String)attributes.get("cn").get();
        userObject.setUserName( commonName );
        if (attributes.get("telephoneNumber") == null){
            System.out.println("Telephone is null for " + commonName);
        }else{
            String telephone = attributes.get("telephoneNumber").get().toString();
            userObject.setTelephone(telephone);
        }
        return userObject;
    }


}