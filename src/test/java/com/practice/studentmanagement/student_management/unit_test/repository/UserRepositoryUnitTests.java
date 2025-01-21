package com.practice.studentmanagement.student_management.unit_test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.practice.studentmanagement.student_management.entity.Student;
import com.practice.studentmanagement.student_management.repository.StudentRepository;

@DataJpaTest
public class UserRepositoryUnitTests {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void addStudent() {
		Student student = new Student("nberse@bsp.gov.ph", "Nikko", "Berse", "Student", "2018-03284-MN-0");
		studentRepository.save(student);
		
		Student foundStudent = studentRepository.findByStudentNumber("2018-03284-MN-0");
		
		assertNotNull(foundStudent);
		assertEquals("2018-03284-MN-0", foundStudent.getStudentNumber());
	}
}
