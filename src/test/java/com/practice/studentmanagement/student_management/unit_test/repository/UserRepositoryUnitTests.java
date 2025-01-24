package com.practice.studentmanagement.student_management.unit_test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.practice.studentmanagement.student_management.entity.Student;
import com.practice.studentmanagement.student_management.repository.StudentRepository;

@DataJpaTest
public class UserRepositoryUnitTests {
	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryUnitTests.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@DisplayName("Add Student Repository Unit Test")
	@Test
	public void addStudent() {
		logger.info("addStudent start");

		Student student = new Student("nberse@bsp.gov.ph", "Nikko", "Berse", "Student", "2018-03284-MN-0");
		studentRepository.save(student);
		
		Student foundStudent = studentRepository.findByStudentNumber("2018-03284-MN-0");
		
		assertNotNull(foundStudent);
		assertEquals("2018-03284-MN", foundStudent.getStudentNumber());
		
		logger.info("addStudent start");
	}
}
