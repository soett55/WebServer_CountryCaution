package com.pss.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Basicinfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String isocode;
	private String basic;

	protected Basicinfo() {}

	public Basicinfo(String isocode, String basic){
		this.isocode = isocode;
		this.basic = basic;
	}
	
	public String getBasic() {
		return basic;
	}
	public long getId() {
		return id;
	}
	public String getIsocode() {
		return isocode;
	}

	@Override
	public String toString() {
		return String.format(
				"Basicinfo[id=%d, isocode='%s', basic='%s']",
				id, isocode, basic);
	}
}
