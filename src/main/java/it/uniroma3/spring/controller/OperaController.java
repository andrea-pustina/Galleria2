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

	@GetMapping("/opera")
    public String showAllOpera(Model model) {
    	List<Opera> operas = (List<Opera>) operaService.findAll();
    	model.addAttribute("operas", operas);
        return "operas";
    }
	
    @GetMapping("/admin/opera/add")
    public String showFormOpera(Opera opera, Model model) {
    	List<Author> authors = (List<Author>) authorService.findAll();
    	List<Technique> techniques = (List<Technique>) techniqueService.findAll();
    	model.addAttribute("techniques", techniques);
    	model.addAttribute("authors", authors);
        return "formopera";
    }

    @PostMapping("/admin/opera/add")
    public String checkOperaInfo(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
        	List<Author> authors = (List<Author>) authorService.findAll();
        	List<Technique> techniques = (List<Technique>) techniqueService.findAll();
        	model.addAttribute("techniques", techniques);
        	model.addAttribute("authors", authors);
            return "formopera";
        }
        else {
        	operaService.add(opera);
        }
        return "summaryopera";
    }
    
    @GetMapping("/admin/opera/update/{operaId}")
    public String showFormOperaPreCompiled(Model model, @PathVariable("operaId") Long operaId) {
    	Opera operaById = operaService.findbyId(operaId);
    	List<Author> authors = (List<Author>) authorService.findAll();
    	List<Technique> techniques = (List<Technique>) techniqueService.findAll();
    	model.addAttribute("techniques", techniques);
    	model.addAttribute("authors", authors);
    	model.addAttribute("operaById", operaById);
        return "formoperaupdate";
    }

    @PostMapping("/admin/opera/update")
    public String checkOperaUpdate(@Valid @ModelAttribute Opera operaById, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
        	List<Author> authors = (List<Author>) authorService.findAll();
        	List<Technique> techniques = (List<Technique>) techniqueService.findAll();
        	model.addAttribute("operaById", operaById);
        	model.addAttribute("techniques", techniques);
        	model.addAttribute("authors", authors);
            return "formoperaupdate";
        }
        else {
        	operaService.add(operaById);
        }
        return "summaryopera";
    }
    
    @GetMapping("/admin/opera/delete/{operaId}")
    public String deleteOpera(Model model, @PathVariable("operaId") Long operaId) {
    	operaService.deleteById(operaId);
    	return "redirect:/opera";
    }
    
}
