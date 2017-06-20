package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
    public String showStartPage() {
		return "redirect:/home";
    }
	
	@GetMapping("/home")
    public String showHome() {
        return "home";
    }
	
	@GetMapping("admin/management")
    public String showManagement() {
        return "management";
    }
	
    @RequestMapping("/login")
    public String login() {
      return "login";
    }
}