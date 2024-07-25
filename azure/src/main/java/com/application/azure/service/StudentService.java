package com.application.azure.service;

import com.application.azure.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> fetchStudents() ;

    public Optional<Student> findStudentByID(int studentID) ;

    public Optional<Boolean> removeStudentByID(int studentID) ;

}
