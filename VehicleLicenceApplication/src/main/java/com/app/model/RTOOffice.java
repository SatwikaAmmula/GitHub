package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * List of RTO offices in Maharashtra
 */
@Entity
public class RTOOffice {
	@Id
	private int rtoId;
	private String rtoName;
	
	
	public int getRtoId() {
		return rtoId;
	}
	public void setRtoId(int rtoId) {
		this.rtoId = rtoId;
	}
	public String getRtoName() {
		return rtoName;
	}
	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}
}
