package com.smartcontact.SmartContactManager.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotBlank(message = "First Name Cannot be Blank")
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;
	
	@NotBlank(message = "Last Name Cannot be Blank")
	@Column(name = "last_name", nullable = false, length = 255)
	private String lastName;
	
	@NotNull(message = "Phone Number Cannot be Blank")
	@Size(min = 10, max = 10, message = "Please Provide a Valid Phone Number")
	@Column(name = "phone_number", nullable = false, length = 255)
	private String phoneNumber;
	
	@Email(message = "Email Is Mandatory Field")
	@Column(unique = true, name = "email", nullable = false, length = 255)
	private String email;
	
	@NotNull(message = "Password Cannot be Null")
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@Column(name = "role",length = 255)
	private String role;
	
	@Column(name = "active", nullable = false, length = 255)
	private boolean active;
	
	@Column(name = "imageName", nullable = true, length = 50)
	private String imageUrl;
	
	@Column(name = "about", nullable = false, length = 500)
	private String about;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userEntity")
	private List<ContactEntity> contactEntities = new ArrayList<>();
}
