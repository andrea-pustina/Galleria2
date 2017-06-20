package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Technique;
import it.uniroma3.spring.service.TechniqueService;


@Controller
public class TechniqueController  {
	
    @Autowired
    private TechniqueService techniqueservice; 

    @GetMapping("/admin/technique/add")
    public String showFormTechnique(Technique technique) {
        return "formtechnique";
    }

    @PostMapping("/admin/technique/add")
    public String checkTechniqueInfo(@Valid @ModelAttribute Technique technique, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "formtechnique";
        }
        else {
            techniqueservice.add(technique); 
        }
        return "summarytechnique";
    }
}
