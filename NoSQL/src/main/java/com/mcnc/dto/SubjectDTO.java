package com.mcnc.dto;

public class SubjectDTO {
	private String subId;
	private String subDec;
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	public String getSubDec() {
		return subDec;
	}
	public void setSubDec(String subDec) {
		this.subDec = subDec;
	}
	@Override
	public String toString() {
		return "SubjectDTO [subId=" + subId + ", subDec=" + subDec + "]";
	}
}
