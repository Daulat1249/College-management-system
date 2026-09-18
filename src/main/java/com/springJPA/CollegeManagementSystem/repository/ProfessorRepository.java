package com.springJPA.CollegeManagementSystem.repository;

import com.springJPA.CollegeManagementSystem.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}