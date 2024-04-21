package com.smartcontact.SmartContactManager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartcontact.SmartContactManager.entities.UserEntity;
import com.smartcontact.SmartContactManager.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity entity = userRepository.getUserByEmail(username);
		
		if(entity == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		
		CustomUserDetails details = new CustomUserDetails(entity);
		
		return details;
	}

}
