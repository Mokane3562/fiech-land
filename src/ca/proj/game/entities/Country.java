package ca.proj.game.entities;

import java.util.ArrayList;

public class Country {
	
	private String countryName;
	private ArrayList<Government> governments;
	
	public Country (String cname) {
		this.countryName=cname;
		this.governments=new ArrayList<Government>();
	}
	
	public String getCountryName() {
		return this.countryName;
	}
	
	public void setCountryName(String cname) {
		this.countryName=cname;
	}
	
	public void addGovernment(Government gov) {
		this.governments.add(gov);
	}
	
	public void removeGovernment(Government gov) {
		this.governments.remove(gov);
	}
}
