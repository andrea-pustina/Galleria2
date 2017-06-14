package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.model.Nation;


public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);
    
    List<Author> findByLastName(String lastName);
    
    List<Author> findByNation(Nation nation);
    
}
