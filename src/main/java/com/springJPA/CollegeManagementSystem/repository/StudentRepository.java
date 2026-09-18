package com.springJPA.CollegeManagementSystem.repository;

import com.springJPA.CollegeManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}