package com.smartcontact.SmartContactManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcontact.SmartContactManager.entities.UserEntity;
import com.smartcontact.SmartContactManager.helper.Message;
import com.smartcontact.SmartContactManager.repositories.UserRepository;
import com.smartcontact.SmartContactManager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	
	@GetMapping("/signup/")
	public String signup(Model model) {
		
		model.addAttribute("user", new UserEntity());
		
		model.addAttribute("title", "Register - Smart Contact Manager");
		return "signup";
	}
	
	 @PostMapping("do_register")
	    public String registerUser(@Valid @ModelAttribute("user") UserEntity userEntity, BindingResult result1,
	            @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
	            HttpSession session) {
	        try {
	            UserEntity result = userService.registerUser(userEntity, agreement);
	            model.addAttribute("user", new UserEntity());
	            session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
	        } catch (Exception e) {
	            e.printStackTrace();
	            model.addAttribute("userEntity", userEntity);
	            session.setAttribute("message", new Message("Something Went Wrong " + e.getMessage(), "alert-danger"));
	        }
	        return "signup";
	    }
	
	@GetMapping("/signin")
	public String 	customLogin(Model model) {
		
		model.addAttribute("title", "Login Page");
		return "login";
	}
}
