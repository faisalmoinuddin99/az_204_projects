package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    // mock db
    private static List<Student> studentDB ;

    static {
        studentDB = new ArrayList<Student>();

        Student student1 = new Student();
        Student student2 = new Student();

        student1.setStudentID(101);
        student1.setStudentName("Raj");
        student1.setStudentAge(24);
        student1.setStudentPhoneNumber("+91 8928331516");

        student2.setStudentID(102);
        student2.setStudentName("Maj");
        student2.setStudentAge(28);
        student2.setStudentPhoneNumber("+91 8928331216");


        studentDB.add(student1) ;
        studentDB.add(student2) ;
    }

    @Override
    public List<Student> findStudentList() {
        return studentDB;
    }

    @Override
    public Optional<Student> findStudentByStudentID(int studentID) {
       return studentDB.stream()
               .filter(student -> student.getStudentID() == studentID)
               .findFirst() ;
    }

    @Override
    public boolean removeStudentByStudentID(int studentID) {
        return studentDB.removeIf(student -> student.getStudentID() == studentID);
    }
}
