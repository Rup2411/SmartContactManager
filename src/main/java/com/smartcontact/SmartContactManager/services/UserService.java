package com.smartcontact.SmartContactManager.services;

import com.smartcontact.SmartContactManager.entities.UserEntity;

public interface UserService {

	 UserEntity registerUser(UserEntity userEntity, boolean agreement) throws Exception;
}
