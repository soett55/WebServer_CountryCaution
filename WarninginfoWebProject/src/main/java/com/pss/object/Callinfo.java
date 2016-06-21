package com.pss.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Callinfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;	
	private String isocode;	
	private String contact;
	private String continent;
	private String countryName;
	private String countryEnName;
	private String imgUrl;
	
	protected Callinfo() {}
	
	public Callinfo(String isocode,	String contact, String continent,
	String countryName, String countryEnName, String imgUrl){
		this.isocode = isocode;
		this.contact = contact;
		this.continent = continent;
		this.countryName = countryName;
		this.countryEnName = countryEnName;
		this.imgUrl = imgUrl;
	}
	
	public String getContact() {
		return contact;
	}
	public String getContinent() {
		return continent;
	}
	public String getCountryEnName() {
		return countryEnName;
	}
	public String getCountryName() {
		return countryName;
	}
	public long getId() {
		return id;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public String getIsocode() {
		return isocode;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Call[id=%d, isocode='%s', contact='%s', continent='%s',"
                + "countryName='%s', countryEnName='%s', imgUrl='%s']",
                id, isocode, contact, continent, countryName,
            	countryEnName, imgUrl);
	}
}
