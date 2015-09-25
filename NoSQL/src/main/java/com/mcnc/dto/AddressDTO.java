package com.mcnc.dto;

public class AddressDTO {
	private String country;
	private String city;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "AddressDTO [country=" + country + ", city=" + city + "]";
	}
}
