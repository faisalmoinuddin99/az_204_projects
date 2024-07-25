package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public List<Student> findStudentList() ;
    public Optional<Student> findStudentByStudentID(int studentID) ;

    public boolean removeStudentByStudentID(int studentID) ;
}
