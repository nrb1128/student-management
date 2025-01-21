package com.practice.studentmanagement.student_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student extends Users {
	
	@JsonIgnore
	@NotBlank(message = "Student Number is required")
	private String studentNumber;

	public Student() {}
	
	public Student(String email, String firstName, String lastName, String role, String studentNumber) {
		super(email, firstName, lastName, role);
		this.studentNumber = studentNumber;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
}
	

