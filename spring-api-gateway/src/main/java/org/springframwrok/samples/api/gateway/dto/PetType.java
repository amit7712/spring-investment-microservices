package org.springframwrok.samples.api.gateway.dto;


import lombok.Data;

@Data
public class PetType {


	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;


}
