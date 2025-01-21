package com.practice.studentmanagement.student_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public class Users {
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Email (message = "Must be a valid email", regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@bsp.gov.ph")
	@NotBlank(message = "Email is required")
	private String email;
	
	@NotBlank (message = "First name is required")
	private String firstName;
	
	@NotBlank (message = "Last name is required")
	private String lastName;
	
	@NotBlank (message = "Role is required")
	private String role;
	
	public Users() {}
	
	public Users(int id, String email, String firstName, String lastName, String role) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	public Users(String email, String firstName, String lastName, String role) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRole() {
		return role;
	}
	
}
