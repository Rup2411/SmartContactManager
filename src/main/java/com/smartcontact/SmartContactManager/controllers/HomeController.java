package com.smartcontact.SmartContactManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcontact.SmartContactManager.entities.UserEntity;
import com.smartcontact.SmartContactManager.repositories.UserRepository;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/signup/")
	public String signup(Model model) {
		
		model.addAttribute("user", new UserEntity());
		
		model.addAttribute("title", "Register - Smart Contact Manager");
		return "signup";
	}
	
	@RequestMapping(value="do_register", method= RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") UserEntity userEntity,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model) {
		
			if(!agreement) {
				System.out.println("You Have Not Agreed Terms and Conditions");
			}
			
			userEntity.setRole("USER_ROLE");
			userEntity.setActive(true);
		
		System.out.println("Agreement" + agreement);
		System.out.println("User" + userEntity);
		
		UserEntity result = this.userRepository.saveAndFlush(userEntity);
		
		model.addAttribute("User " + result);
		return "signup";
	}
}
