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
import it.uniroma3.spring.model.Opera;
import it.uniroma3.spring.model.Technique;
import it.uniroma3.spring.service.AuthorService;
import it.uniroma3.spring.service.OperaService;
import it.uniroma3.spring.service.TechniqueService;

@Controller
public class OperaController {
	@Autowired
    private OperaService operaService; 
	
	@Autowired
    private TechniqueService techniqueService;
	
	@Autowired
    private AuthorService authorService;

    @GetMapping("/opera/add")
    public String showFormOpera(Opera opera, Model model) {
    	List<Author> authors = (List<Author>) authorService.findAll();
    	List<Technique> techniques = (List<Technique>) techniqueService.findAll();
    	model.addAttribute("techniques", techniques);
    	model.addAttribute("authors", authors);
        return "formopera";
    }

    @PostMapping("/opera/add")
    public String checkCustomerInfo(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "formopera";
        }
        else {
        	//model.addAttribute(nation);
        	//dimensionService.add(opera.getDimension());
            operaService.add(opera);
            
        }
        return "summaryopera";
    }
    
    @GetMapping("/opera")
    public String showAllOpera(Model model) {
    	List<Opera> operas = (List<Opera>) operaService.findAll();
    	model.addAttribute("operas", operas);
        return "operas";
    }
}
