package it.uniroma3.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Nation;
import it.uniroma3.spring.service.NationService;

@Controller
public class NationController {
	@Autowired
    private NationService nationService; 

    @GetMapping("/nation/add")
    public String showFormNation(Nation nation) {
        return "formnation";
    }

    @PostMapping("/nation/add")
    public String checkNationInfo(@Valid @ModelAttribute Nation nation, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "formnation";
        }
        else {
        	//smodel.addAttribute(nation);
            nationService.add(nation); 
        }
        return "summarynation";
    }
}
