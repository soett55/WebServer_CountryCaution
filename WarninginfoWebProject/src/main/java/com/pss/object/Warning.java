package com.pss.object;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warning {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;	
	private String isocode;	
	private String continent;
	private String countryName;
	private String countryEnName;
	private String imgUrl2;
	private String attentionNote;
	private String controlNote;	
	private String limitNote;

	protected Warning() {}
	
	public Warning(String isocode, String continent, String countryName,
	String countryEnName, String imgUrl2, String attentionNote, String controlNote, String limitNote) 
	{
		this.isocode = isocode;
		this.continent = continent;
		this.countryName = countryName;
		this.countryEnName = countryEnName;
		this.imgUrl2 = imgUrl2;
		this.attentionNote = attentionNote;
		this.controlNote = controlNote;
		this.limitNote = limitNote;
	}
	
	public String getAttentionNote() {
		return attentionNote;
	}
	public String getContinent() {
		return continent;
	}
	public String getControlNote() {
		return controlNote;
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
	public String getImgUrl2() {
		return imgUrl2;
	}
	public String getIsocode() {
		return isocode;
	}
	public String getLimitNote() {
		return limitNote;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Warning[id=%d, isocode='%s', continent='%s'"
                + "countryName='%s', countryEnName='%s', ImgUrl2='%s', attentionNote='%s'"
                + "controlNote='%s', limitNote='%s']",
                id, isocode, continent, countryName,
            	countryEnName, imgUrl2, attentionNote, controlNote, limitNote);
    }
}
