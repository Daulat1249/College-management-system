package com.springJPA.CollegeManagementSystem.repository;

import com.springJPA.CollegeManagementSystem.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}