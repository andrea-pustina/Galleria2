package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Nation;


public interface NationRepository extends CrudRepository<Nation, Long> {

    List<Nation> findByName(String name);
    
}
