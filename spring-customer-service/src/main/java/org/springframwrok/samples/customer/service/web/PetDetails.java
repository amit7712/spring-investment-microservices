package org.springframwrok.samples.customer.service.web;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframwrok.samples.customer.service.model.Pet;
import org.springframwrok.samples.customer.service.model.PetType;

import lombok.Data;


@Data
class PetDetails {

    private long id;

    private String name;

    private String owner;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private PetType type;

    PetDetails(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.owner = pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName();
        this.birthDate = pet.getBirthDate();
        this.type = pet.getType();
    }
}
