package org.springframwrok.samples.api.gateway.boundary.web;


import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframwrok.samples.api.gateway.application.CustomersServiceClient;
import org.springframwrok.samples.api.gateway.application.VisitsServiceClient;
import org.springframwrok.samples.api.gateway.dto.OwnerDetails;
import org.springframwrok.samples.api.gateway.dto.VisitDetails;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gateway")
public class ApiGatewayController {
	@Autowired
    private  CustomersServiceClient customersServiceClient;
	@Autowired
    private  VisitsServiceClient visitsServiceClient;

    @GetMapping(value = "owners/{ownerId}")
    public OwnerDetails getOwnerDetails( @PathVariable int ownerId) {
         OwnerDetails owner = customersServiceClient.getOwner(ownerId);
        supplyVisits(owner, visitsServiceClient.getVisitsForPets(owner.getPetIds()));
        return owner;
    }

    private void supplyVisits( OwnerDetails owner,  Map<Integer, List<VisitDetails>> visitsMapping) {
        owner.getPets().forEach(pet ->
            pet.getVisits().addAll(Optional.ofNullable(visitsMapping.get(pet.getId())).orElse(emptyList())));
    }
}
