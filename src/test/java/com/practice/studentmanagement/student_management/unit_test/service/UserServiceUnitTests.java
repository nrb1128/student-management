package com.practice.studentmanagement.student_management.unit_test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.practice.studentmanagement.student_management.entity.Student;
import com.practice.studentmanagement.student_management.repository.StudentRepository;
import com.practice.studentmanagement.student_management.serviceImpl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTests {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceUnitTests.class);

	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@DisplayName("Add Student Unit Test")
	@Test
	public void addStudent() {
		logger.info("addStudent start");

		Student student = new Student("nberse@bsp.gov.ph", "Nikko", "Berse", "Student", "2018-03284-MN-0");

		when(studentRepository.save(student)).thenReturn(student);

		Student result = userServiceImpl.addStudent(student);

		assertNotNull(result);
		assertEquals(student.getEmail(), result.getEmail());
		assertEquals(student.getStudentNumber(), result.getStudentNumber());

		verify(studentRepository, times(1)).save(student);

		logger.info("addStudent end");
	}
}
