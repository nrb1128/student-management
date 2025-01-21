package com.practice.studentmanagement.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.studentmanagement.student_management.entity.Student;
import com.practice.studentmanagement.student_management.serviceImpl.UserServiceImpl;

@Controller
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping(value = "/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student createdStudent = userServiceImpl.addStudent(student);

		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}

	@GetMapping(value = "/students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> studentList = userServiceImpl.getStudents();

		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@GetMapping(value = "/students/{studentNumber}")
	public ResponseEntity<Student> getStudents(@PathVariable String studentNumber) {
		Student student = userServiceImpl.getStudent(studentNumber);

		return ResponseEntity.ok(student);
	}

	@DeleteMapping(value = "/students/delete")
	public ResponseEntity<String> deleteStudent(@RequestParam String studentNumber) {
		Student student = userServiceImpl.getStudent(studentNumber);

		if (student != null) {
			userServiceImpl.deleteStudent(studentNumber);
			return ResponseEntity.ok("Student successfully deleted");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value = "/students/delete-all")
	public ResponseEntity<String> deleteAllStudent() {
		userServiceImpl.deleteAllStudent();

		return ResponseEntity.ok("Students successfully deleted");
	}
}
