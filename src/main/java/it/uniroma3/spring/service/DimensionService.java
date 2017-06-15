package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Dimension;
import it.uniroma3.spring.repository.DimensionRepository;

@Service
public class DimensionService {
	@Autowired
    private DimensionRepository dimensionRepository; 

    @Transactional
    public void add(final Dimension dimension) {
        this.dimensionRepository.save(dimension);
    }

	public Dimension findbyId(Long id) {
		return this.dimensionRepository.findOne(id);
	}
	
}
