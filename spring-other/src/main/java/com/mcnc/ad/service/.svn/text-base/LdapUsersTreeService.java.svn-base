package com.mcnc.ad.service;
import java.util.List;

import javax.naming.directory.SearchControls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;

import com.mcnc.ad.dto.DepartmentTree;
import com.mcnc.ad.dto.User;
import com.mcnc.ad.mapper.DepartmentAttributesMapper;

public class LdapUsersTreeService {
	@Autowired 
	private LdapTemplate ldapTemplate;
	
	private String searchBase;

	public String getSearchBase() {
		return searchBase;
	}

	public void setSearchBase(String searchBase) {
		this.searchBase = searchBase;
	}

	
	public DepartmentTree constructDepartmentTree(){
		String treeRootName = getSearchBase().split(",")[0].split("=")[1];
		return this.getDepartmentTree(treeRootName , getSearchBase());
	}
	
	
	
	private DepartmentTree getDepartmentTree(String rootName, String searchBase){
		DepartmentTree tree = new DepartmentTree();
		tree.setDepartmentName(rootName);
		
		SearchControls controls = new SearchControls( );
		controls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
		try{
			List< Object > resultList =  ldapTemplate.search(searchBase , 
					"(|(objectClass=person)((objectClass=organizationalUnit)))", controls, 
					new DepartmentAttributesMapper());
			
			for( Object iterate : resultList ){
				if( iterate instanceof User ){
					User element = ( User ) iterate;
					tree.getUserChildren().add( element );
				}
				else if( iterate instanceof DepartmentTree ){
					DepartmentTree element = ( DepartmentTree ) iterate;
					element = this.getDepartmentTree( element.getDepartmentName(), "OU=" + element.getDepartmentName() + "," + searchBase );
					tree.getDepartmentChildren().add( element );
				} 
			}
		}catch  (Exception e ) {
			e.printStackTrace();
		}
		
		return tree;
	}

}