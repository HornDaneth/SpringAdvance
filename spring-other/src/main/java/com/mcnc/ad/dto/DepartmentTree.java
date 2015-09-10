package com.mcnc.ad.dto;
import java.util.ArrayList;
import java.util.List;
public class DepartmentTree{
	private String departmentName;
	private List< DepartmentTree > departmentChildren = new ArrayList< DepartmentTree >();
	private List< User > userChildren = new ArrayList< User >();
	
	public List< DepartmentTree > getDepartmentChildren() {
		return departmentChildren;
	}
	public void setDepartmentChildren(List<DepartmentTree> departmentChildren) {
		this.departmentChildren = departmentChildren;
	}
	public List<User> getUserChildren() {
		return userChildren;
	}
	public void setUserChildren(List<User> userChildren) {
		this.userChildren = userChildren;
	}
	public boolean isLeaf(){
		if(  getDepartmentChildren().size() == 0 && userChildren.size() == 0 )
			return true;
		return false;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		return "DepartmentTree [departmentName="
				+ departmentName
				+ ", departmentChildren="
				+ (departmentChildren != null ? departmentChildren.subList(0,
						Math.min(departmentChildren.size(), maxLen)) : null)
				+ ", userChildren="
				+ (userChildren != null ? userChildren.subList(0,
						Math.min(userChildren.size(), maxLen)) : null) + "]";
	}
	
	
}