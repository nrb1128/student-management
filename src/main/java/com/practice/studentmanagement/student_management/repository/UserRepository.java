package com.practice.studentmanagement.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.studentmanagement.student_management.entity.Student;

public interface UserRepository extends JpaRepository<Student, Integer> {
}
