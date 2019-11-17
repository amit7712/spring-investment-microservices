package org.springframwrok.samples.api.gateway.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframwrok.samples.api.gateway.dto.OwnerDetails;

import lombok.RequiredArgsConstructor;

/**
 * @author Maciej Szarlinski
 */
@Component
@RequiredArgsConstructor
public class CustomersServiceClient {

	@Autowired
    private  RestTemplate loadBalancedRestTemplate;

    public OwnerDetails getOwner( int ownerId) {
        return loadBalancedRestTemplate.getForObject("http://customers-service/owners/{ownerId}", OwnerDetails.class, ownerId);
    }
}
