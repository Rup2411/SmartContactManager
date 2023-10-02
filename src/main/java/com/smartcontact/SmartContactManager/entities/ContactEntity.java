package com.smartcontact.SmartContactManager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "contacts")
public class ContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;
	
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;
	
	@Column(name = "last_name", nullable = true, length = 255)
	private String lastName;
	
	@Column(name = "nick_name", nullable = true, length = 255)
	private String nickName;
	
	@Column(name = "email", nullable = true, length = 255)
	private String email;
	
	@Column(name = "relation", nullable = true, length = 255)
	private String relation;
	
	@Column(name = "phone_number", nullable = false, length = 255)
	private String phoneNumber;
	
	@Column(name = "contactImageName", nullable = true, length = 50)
	private String contactImageUrl;
	
	@Column(name = "description", nullable = true, length = 5000)
	private String description;
	
	@ManyToOne
	private UserEntity userEntity;
	
}
