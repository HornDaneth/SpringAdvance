package com.mcnc.tile.constraint;

public enum View {
	CONTACT ("contact");
	
	private String value;
	
	View( String value ){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
