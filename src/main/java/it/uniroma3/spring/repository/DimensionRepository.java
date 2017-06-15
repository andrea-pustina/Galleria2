package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Dimension;


public interface DimensionRepository extends CrudRepository<Dimension, Long> {
    
}
