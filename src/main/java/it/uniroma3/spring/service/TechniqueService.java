package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.spring.model.Technique;
import it.uniroma3.spring.repository.TechniqueRepository;


@Service
public class TechniqueService {

    @Autowired
    private TechniqueRepository techniqueRepository; 

    public Iterable<Technique> findAll() {
        return this.techniqueRepository.findAll();
    }

    @Transactional
    public void add(final Technique technique) {
        this.techniqueRepository.save(technique);
    }

	public Technique findbyId(Long id) {
		return this.techniqueRepository.findOne(id);
	}

}
