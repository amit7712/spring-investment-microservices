package org.springframwrok.samples.visit.service.web;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframwrok.samples.visit.service.model.Visit;
import org.springframwrok.samples.visit.service.model.VisitRepository;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequiredArgsConstructor
@Slf4j
@Timed("petclinic.visit")
class VisitResource {
	
	@Autowired
    private  VisitRepository visitRepository;

    @PostMapping("owners/*/pets/{petId}/visits")
    @ResponseStatus(HttpStatus.CREATED)
    Visit create(
        @Valid @RequestBody Visit visit,
        @PathVariable("petId") int petId) {

        visit.setPetId(petId);
       // log.info("Saving visit {}", visit);
        return visitRepository.save(visit);
    }

    @GetMapping("owners/*/pets/{petId}/visits")
    List<Visit> visits(@PathVariable("petId") int petId) {
        return visitRepository.findByPetId(petId);
    }

    @GetMapping("pets/visits")
    Visits visitsMultiGet(@RequestParam("petId") List<Integer> petIds) {
         List<Visit> byPetIdIn = visitRepository.findByPetIdIn(petIds);
         
        return new Visits(byPetIdIn);
    }

    @Value
     class Visits {
        private  List<Visit> items;

		public Visits(List<Visit> items) {
		
			this.items = items;
		}
        
    }
}
