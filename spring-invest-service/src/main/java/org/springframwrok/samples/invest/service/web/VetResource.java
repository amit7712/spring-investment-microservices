package org.springframwrok.samples.invest.service.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframwrok.samples.invest.service.model.Vet;
import org.springframwrok.samples.invest.service.model.VetRepository;

import lombok.RequiredArgsConstructor;

 
@RequestMapping("/vets")
@RestController
@RequiredArgsConstructor
class VetResource {
	
	@Autowired
    private  VetRepository vetRepository;

    @GetMapping
    public List<Vet> showResourcesVetList() {
        return vetRepository.findAll();
    }
}
