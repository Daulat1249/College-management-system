package com.springJPA.CollegeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "students")  //inverse side
    private List<Professor> professors = new ArrayList<>();

    @ManyToMany
    private List<Subject> subjects = new ArrayList<>();

    @OneToOne(mappedBy = "student")
    private AdmissionRecord admissionRecord;
}
