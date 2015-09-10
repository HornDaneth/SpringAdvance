package com.mcnc.util;

public enum Scale{
	QUALTER(0.15F),
	HALF(0.5F),
	THIRD_QUALTER(0.75F),
	FULL(1F);
	
	private float value;
	Scale(float value){
		this.value = value;
	}
	public float getValue() {
		return value;
	}
	
/*	public static Scale get(float value){
		return Scale.
	}
	*/
}
