package com.mcnc.ad.mapper;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import com.mcnc.ad.dto.DepartmentTree;
import com.mcnc.ad.dto.User;


public class DepartmentAttributesMapper implements AttributesMapper<Object> {

	public Object mapFromAttributes( Attributes attributes ) throws NamingException {
		
		boolean isUserType = false;
		Attribute userAttribute = attributes.get( "cn" );
        if( userAttribute != null )
        	isUserType = true;
		
        
        if( isUserType ){
        	/*User Type*/
			User user = new User();
			Attribute userNameAttr = attributes.get( "cn" );
	        if( userNameAttr != null )
	        	user.setFullName( userNameAttr.get( 0 ).toString());
	        // get login name
	        Attribute loginNameAttr = attributes.get( "sAMAccountName" );
	        if( loginNameAttr != null )
	        	user.setUserName( loginNameAttr.get( 0 ).toString());
	        // get email 
	        Attribute mailAttr= attributes.get( "mail" );
	        if( mailAttr != null )
	        	user.setEmail( mailAttr.get( 0 ).toString() );
	        return user;
        }else{
        	/*Department Type*/
        	DepartmentTree depart = new DepartmentTree();
        	Attribute ouAttr = attributes.get( "ou" );
	        if( ouAttr != null )
	        	depart.setDepartmentName( ouAttr.get( 0 ).toString() );
        	return depart;
        }
		
	}

}