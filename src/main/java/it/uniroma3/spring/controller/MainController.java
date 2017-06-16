package it.uniroma3.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// controller to access the login page
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
	
    // Login form
    @RequestMapping("/login")
    public String login() {
      return "login";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
      model.addAttribute("loginError", true);
      return "login";
    }
    
//    @GetMapping("/logout")
//    public String logout() {
//        return "home";
//    }

}