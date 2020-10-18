package com.pfoa.docverify.dto;

import java.util.Date;

public class DocDetails {
	String name;
	Date dateCreated;
	String owner;
	
	public DocDetails(String name, Date dateCreated, String owner) {
		super();
		this.name = name;
		this.dateCreated = dateCreated;
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
