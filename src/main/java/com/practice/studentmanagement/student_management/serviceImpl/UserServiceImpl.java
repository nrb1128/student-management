package com.practice.studentmanagement.student_management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.studentmanagement.student_management.entity.Student;
import com.practice.studentmanagement.student_management.repository.StudentRepository;
import com.practice.studentmanagement.student_management.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(String studentNumber) {
		return studentRepository.findByStudentNumber(studentNumber);
	}

	@Override
	public void deleteStudent(String studentNumber) {
		studentRepository.deleteByStudentNumber(studentNumber);
	}

	@Override
	public void deleteAllStudent() {
		studentRepository.deleteAll();
		
	}
}
