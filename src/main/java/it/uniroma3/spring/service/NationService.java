package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Nation;
import it.uniroma3.spring.repository.NationRepository;

@Service
public class NationService {
	@Autowired
    private NationRepository nationRepository; 

    public Iterable<Nation> findAll() {
        return this.nationRepository.findAll();
    }

    @Transactional
    public void add(final Nation nation) {
        this.nationRepository.save(nation);
    }

	public Nation findbyId(Long id) {
		return this.nationRepository.findOne(id);
	}
	
}
