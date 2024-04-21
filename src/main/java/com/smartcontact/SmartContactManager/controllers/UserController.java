package com.smartcontact.SmartContactManager.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartcontact.SmartContactManager.entities.ContactEntity;
import com.smartcontact.SmartContactManager.entities.UserEntity;
import com.smartcontact.SmartContactManager.repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserRepository repository;
	
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		
		String userName = principal.getName();
		
		UserEntity user = repository.getUserByEmail(userName);
		
		model.addAttribute("user", user);
	}
	
	@GetMapping("/index")
	public String dashboard(Model model, Principal principal) {
		
		model.addAttribute("title", "User Dashboard");
		
		return "normal/user_dashboard";
	}
	
	@GetMapping("/add/contact")
	public String addContactForm(Model model, Principal principal) {
		
		model.addAttribute("title", "Add Contact");
		model.addAttribute("contact", new ContactEntity());
		
		return "normal/add_contact_form";
	}
	
	@PostMapping("/process/contact")
	public String processContact(@ModelAttribute ContactEntity contact, Principal principal) {
		
		String name = principal.getName();
		UserEntity user = repository.getUserByEmail(name);
		
		contact.setUserEntity(user);
		
		user.getContactEntities().add(contact);	
		
		repository.saveAndFlush(user);
		
		return "normal/add_contact_form";
	}
}
