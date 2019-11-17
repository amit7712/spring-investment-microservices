package org.springframwrok.samples.visit.service.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitRepository extends JpaRepository<Visit, Integer> {

    List<Visit> findByPetId(int petId);

    List<Visit> findByPetIdIn(Iterable<Integer> petIds);
}
