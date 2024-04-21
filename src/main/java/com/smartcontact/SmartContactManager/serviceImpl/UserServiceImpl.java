package com.smartcontact.SmartContactManager.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartcontact.SmartContactManager.entities.UserEntity;
import com.smartcontact.SmartContactManager.repositories.UserRepository;
import com.smartcontact.SmartContactManager.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private BCryptPasswordEncoder encoder;

	    @Override
	    public UserEntity registerUser(UserEntity userEntity, boolean agreement) throws Exception {
	        if (!agreement) {
	            throw new Exception("You Have Not Agreed Terms and Conditions");
	        }

	        // Encode the password before saving it
	        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
	        userEntity.setRole("ROLE_USER");
	        userEntity.setActive(true);
	        userEntity.setImageUrl("default.png");

	        return userRepository.saveAndFlush(userEntity);
	    }

}
