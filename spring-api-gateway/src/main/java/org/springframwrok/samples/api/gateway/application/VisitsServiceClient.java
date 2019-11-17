package org.springframwrok.samples.api.gateway.application;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframwrok.samples.api.gateway.dto.VisitDetails;
import org.springframwrok.samples.api.gateway.dto.Visits;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class VisitsServiceClient {
	
	@Autowired
    private  RestTemplate loadBalancedRestTemplate;

    @HystrixCommand(fallbackMethod = "emptyVisitsForPets")
    public Map<Integer, List<VisitDetails>> getVisitsForPets( List<Integer> petIds) {
        UriComponentsBuilder builder = fromHttpUrl("http://visits-service/pets/visits")
            .queryParam("petId", joinIds(petIds));

        return loadBalancedRestTemplate.getForObject(builder.toUriString(), Visits.class)
            .getItems()
            .stream()
            .collect(groupingBy(VisitDetails::getPetId));
    }

    private String joinIds(List<Integer> petIds) {
        return petIds.stream().map(Object::toString).collect(joining(","));
    }

    private Map<Integer, List<VisitDetails>> emptyVisitsForPets(List<Integer> petIds) {
        return Collections.emptyMap();
    }
}
