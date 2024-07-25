package com.application.azure.service;

import com.application.azure.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static List<Student> studentDB;

    static {
        studentDB = new ArrayList<Student>();


        Student student1 = new Student();
        Student student2 = new Student();

        student1.setStudentID(101);
        student1.setStudentName("Raj");
        student1.setAge(24);
        student1.setStudentPhoneNumber("+91 8928331516");

        student2.setStudentID(102);
        student2.setStudentName("Maj");
        student2.setAge(28);
        student2.setStudentPhoneNumber("+91 8928331216");


        studentDB.add(student1) ;
        studentDB.add(student2) ;
    }

    @Override
    public List<Student> fetchStudents() {
        return studentDB;
    }

    @Override
    public Optional<Student> findStudentByID(int studentID) {
        return studentDB.stream().filter(
                student -> student.getStudentID() == studentID
        ).findFirst();
    }

    @Override
    public Optional<Boolean> removeStudentByID(int studentID) {
        return Optional.of(studentDB.removeIf(student -> student.getStudentID() == studentID));
    }
}
