package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.repository.AuthorRepository;
import it.uniroma3.spring.repository.OperaRepository;

@Service
public class OperaService {
	@Autowired
    private OperaRepository operaRepository; 
	
	@Autowired
    private AuthorRepository authorRepository; 

    public Iterable<Opera> findAll() {
        return this.operaRepository.findAll();
    }

    @Transactional
    public void add(final Opera opera) {
        this.operaRepository.save(opera);
    }

	public Opera findbyId(Long id) {
		return this.operaRepository.findOne(id);
	}
	
//	public List<Opera> findbyAuthorId(Long authorId) {
//		Author author = this.authorRepository.findOne(authorId);
//		return this.operaRepository.findByAuthor(author);
//	}
	
	public List<Opera> findbyAuthor(Author author) {
		return this.operaRepository.findByAuthor(author);
	}
	
}
