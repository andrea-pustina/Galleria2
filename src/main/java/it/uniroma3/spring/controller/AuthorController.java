package it.uniroma3.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.model.Nation;
import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.service.AuthorService;
import it.uniroma3.spring.service.NationService;
import it.uniroma3.spring.service.OperaService;

@Controller
public class AuthorController {
	@Autowired
    private AuthorService authorService; 
	
	@Autowired
    private NationService nationService; 
	
	@Autowired
	private OperaService operaService;

    @GetMapping("/author/add")
    public String showFormAuthor(Author author, Model model) {
    	List<Nation> nations = (List<Nation>) nationService.findAll();
    	model.addAttribute("nations", nations);
        return "formauthor";
    }

    @PostMapping("/author/add")
    public String checkCustomerInfo(@Valid @ModelAttribute Author author, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "formauthor";
        }
        else {
        	//model.addAttribute(nation);
            authorService.add(author); 
        }
        return "summaryauthor";
    }
    
    @GetMapping("/author")
    public String showAllAuthors( Model model) {
    	List<Author> authors = (List<Author>) authorService.findAll();
    	model.addAttribute("authors", authors);
        return "authors";
    }
    
//    @GetMapping("/author/detail")
//    public String showAuthorDetail( Model model) {
//    	List<Opera> operas = (List<Opera>) operaService.findAll();
//    	model.addAttribute("operas", operas);
//        return "authordetail";
//    }
    
    @GetMapping("/author/{authorId}")
    public String showAuthorsDetails(Model model, @PathVariable("authorId") Long authorId ) {
    	Author author = authorService.findbyId(authorId);
    	List<Opera> operas = operaService.findbyAuthor(author);
    	model.addAttribute("author", author);
    	model.addAttribute("operas", operas);
        return "summaryauthor";
    }
}
