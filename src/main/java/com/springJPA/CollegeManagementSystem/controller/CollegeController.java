package com.springJPA.CollegeManagementSystem.controller;

import com.springJPA.CollegeManagementSystem.entity.AdmissionRecord;
import com.springJPA.CollegeManagementSystem.entity.Professor;
import com.springJPA.CollegeManagementSystem.entity.Student;
import com.springJPA.CollegeManagementSystem.entity.Subject;
import com.springJPA.CollegeManagementSystem.service.CollegeManagementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/college")
public class CollegeController {

    private final CollegeManagementService collegeManagementService;

    public CollegeController(CollegeManagementService collegeManagementService){
        this.collegeManagementService = collegeManagementService;
    }

    //API to assign subject to a professor
    @PutMapping("/subjects/{subjectId}/professors/{professorId}")
    public Subject assignSubjectToProfessor(@PathVariable Long subjectId, @PathVariable Long professorId){
        return collegeManagementService.assignSubjectToProfessor(subjectId, professorId);
    }

    //API to assign student to a professor
    @PutMapping("/professor/{professorId}/students/{studentId}")
    public Professor assignStudentToProfessor(@PathVariable Long professorId, @PathVariable Long studentId){
        return collegeManagementService.assignStudentToProfessor(professorId, studentId);
    }

    @PostMapping("/professors")
    public Professor createProfessor(@RequestBody Professor professor){
        return collegeManagementService.addProfessor(professor);
    }

    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject){
        return collegeManagementService.addSubject(subject);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return collegeManagementService.addStudent(student);
    }

    @PostMapping("/students/{studentId}/admissions")
    public AdmissionRecord createAdmissionRecord(@PathVariable Long studentId,@RequestBody AdmissionRecord admissionRecord){
        return collegeManagementService.assignAdmissionRecordToStudent(studentId, admissionRecord);
    }
}
