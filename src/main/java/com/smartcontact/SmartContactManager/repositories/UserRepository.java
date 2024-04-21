package com.smartcontact.SmartContactManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartcontact.SmartContactManager.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	
	@Query(value = "SELECT * FROM users WHERE email = :x", nativeQuery = true)
	UserEntity getUserByEmail(@Param("x") String email);
}
