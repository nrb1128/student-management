package com.practice.studentmanagement.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.studentmanagement.student_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query
	public Student findByStudentNumber(String studentNumber);

	@Modifying
	@Query("DELETE FROM Student s WHERE s.studentNumber = :studentNumber")
	void deleteByStudentNumber(@Param("studentNumber") String studentNumber);
}
