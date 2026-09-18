package com.springJPA.CollegeManagementSystem.service;

import com.springJPA.CollegeManagementSystem.entity.AdmissionRecord;
import com.springJPA.CollegeManagementSystem.entity.Professor;
import com.springJPA.CollegeManagementSystem.entity.Student;
import com.springJPA.CollegeManagementSystem.entity.Subject;
import com.springJPA.CollegeManagementSystem.repository.AdmissionRecordRepository;
import com.springJPA.CollegeManagementSystem.repository.ProfessorRepository;
import com.springJPA.CollegeManagementSystem.repository.StudentRepository;
import com.springJPA.CollegeManagementSystem.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CollegeManagementService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final AdmissionRecordRepository admissionRecordRepository;

    public CollegeManagementService(ProfessorRepository professorRepository,
                                    StudentRepository studentRepository,
                                    SubjectRepository subjectRepository, AdmissionRecordRepository admissionRecordRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.admissionRecordRepository = admissionRecordRepository;
    }

    // 1. Assign Subject to Professor
    // The Subject entity owns this relationship (it holds the professor_id foreign key)
    @Transactional
    public Subject assignSubjectToProfessor(Long subjectId, Long professorId){
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new RuntimeException("Subject Not Found"));
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new RuntimeException("Professor Not Found"));

        subject.setProfessor(professor);
        return subjectRepository.save(subject);
    }

    // 2. Assign Student to Professor
    // The Professor entity owns this Many-to-Many relationship
    @Transactional
    public Professor assignStudentToProfessor(Long professorId, Long studentId){
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new RuntimeException("Professor Not Found"));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student Not Found"));

        professor.getStudents().add(student);
        return professorRepository.save(professor);
    }

    public Professor addProfessor(Professor professor){
        return professorRepository.save(professor);
    }
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public AdmissionRecord addAdmissionRecord(AdmissionRecord admissionRecord){
        return admissionRecordRepository.save(admissionRecord);
    }

    @Transactional
    public AdmissionRecord assignAdmissionRecordToStudent(Long studentId, AdmissionRecord record) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        record.setStudent(student); // Fulfills the nullable=false constraint
        return admissionRecordRepository.save(record);
    }
}
