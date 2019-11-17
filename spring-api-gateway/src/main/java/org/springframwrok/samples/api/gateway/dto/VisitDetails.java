package org.springframwrok.samples.api.gateway.dto;


import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor
public class VisitDetails {

 



	 public Integer getId() {
		return id;
	}

	/* public void setId(Integer id) {
		this.id = id;
	} */

	public Integer getPetId() {
		return petId;
	}

	/* 	public void setPetId(Integer petId) {
		this.petId = petId;
	} */

	public String getDate() {
		return date;
	}

	/* 	public void setDate(String date) {
		this.date = date;
	} */

	public String getDescription() {
		return description;
	}

	/*  public void setDescription(String description) {
		this.description = description;
	} */

	private Integer id = null;

	 private Integer petId = null;

	 private String date = null;

	 private String description = null;
    
    
    
}
