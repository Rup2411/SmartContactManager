package com.smartcontact.SmartContactManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcontact.SmartContactManager.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
