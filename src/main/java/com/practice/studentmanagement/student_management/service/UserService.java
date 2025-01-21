package com.practice.studentmanagement.student_management.service;

import java.util.List;

import com.practice.studentmanagement.student_management.entity.Student;

public interface UserService {
	public Student addStudent(Student student);
	public List<Student> getStudents();
	public Student getStudent (String studentNumber);
	public void deleteStudent (String studentNumber);
	public void deleteAllStudent();
}
