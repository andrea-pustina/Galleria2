package it.uniroma3.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.model.Nation;
import it.uniroma3.spring.service.AuthorService;
import it.uniroma3.spring.service.NationService;

@Controller
public class AuthorController {
	@Autowired
    private AuthorService authorService; 
	
	@Autowired
    private NationService nationService; 

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
}
