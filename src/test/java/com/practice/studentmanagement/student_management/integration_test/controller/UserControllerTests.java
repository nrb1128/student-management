package com.practice.studentmanagement.student_management.integration_test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.practice.studentmanagement.student_management.entity.Student;
import com.practice.studentmanagement.student_management.serviceImpl.UserServiceImpl;
import com.practice.studentmanagement.student_management.unit_test.service.UserServiceUnitTests;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceUnitTests.class);

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserServiceImpl userServiceImpl;

	@DisplayName("Get Students Integration Test")
	@Test
	void testGetStudents() throws Exception {
		logger.info("testGetStudents start");

		List<Student> students = new ArrayList<>();
		Student student = new Student("nberse@bsp.gov.ph", "Nikko", "Berse", "Student", "2018-03284-MN-0");
		students.add(student);

		when(userServiceImpl.getStudents()).thenReturn(students);

		mockMvc.perform(get("/api/users/students")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()").value(1))
				.andExpect(jsonPath("$[0].email").value(student.getEmail()));

		logger.info("testGetStudents end");
	}
}
