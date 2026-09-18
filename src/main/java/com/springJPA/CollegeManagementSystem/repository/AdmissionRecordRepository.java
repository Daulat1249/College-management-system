package com.springJPA.CollegeManagementSystem.repository;

import com.springJPA.CollegeManagementSystem.entity.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {
}