package org.springframwrok.samples.api.gateway.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class PetDetails {


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public PetType getType() {
		return type;
	}

	public List<VisitDetails> getVisits() {
		return visits;
	}

	 private int id;

	 private String name;

	 private String birthDate;

	 private PetType type;

	 private  List<VisitDetails> visits = new ArrayList<>();

}
