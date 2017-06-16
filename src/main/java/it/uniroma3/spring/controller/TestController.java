package it.uniroma3.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.model.Dimension;
import it.uniroma3.spring.model.Nation;
import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.model.Technique;
import it.uniroma3.spring.service.AuthorService;
import it.uniroma3.spring.service.NationService;
import it.uniroma3.spring.service.OperaService;
import it.uniroma3.spring.service.TechniqueService;

@Controller
public class TestController {
	@Autowired
    private AuthorService authorService; 
	
	@Autowired
    private NationService nationService; 
	
	@Autowired
    private TechniqueService techniqueService; 
	
	@Autowired
    private OperaService operaService; 

    @GetMapping("/test/inizializzadatabase")
    public String initializeDatabase() {
    	
    	Technique t1 = new Technique("acquarelli");
		Technique t2 = new Technique("olio");
		techniqueService.add(t1);
		techniqueService.add(t2);
		
		
		Nation n1 = new Nation("it");
		Nation n2 = new Nation("en");
		nationService.add(n1);
		nationService.add(n2);
		
		
		Author a1 = new Author("andrea", "pustina", new Date(1231261), new Date(424676), n1 );
		Author a2 = new Author("andrea", "gaggiotti", new Date(12341261), new Date(4234676), n2 );
		authorService.add(a1);
		authorService.add(a2);
		
		Opera o1 = new Opera("sto", 1995, new Dimension(22,23), a1, t1);
		Opera o2 = new Opera("colo", 1993, new Dimension(11,12), a2, t2);
		operaService.add(o1);
		operaService.add(o2);
    	
    	return"redirect:/admin/management";
    }
}

