package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Technique;

public interface TechniqueRepository extends CrudRepository<Technique, Long> {

    List<Technique> findByName(String name);
}