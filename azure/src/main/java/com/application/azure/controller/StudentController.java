package com.application.azure.controller;

import com.application.azure.model.Student;
import com.application.azure.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {


    private final StudentServiceImpl service;

    @Autowired
    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        Optional<Student> student = service.findStudentByID(id);


        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            String errorMessage = "Student " + id + " Not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents() {
        List<Student> studentList = service.fetchStudents();
        if (studentList.isEmpty()) {
            String errorMessage = "Database is empty" ;
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorMessage);
        } else {
            return ResponseEntity.ok(studentList);
        }
    }
}
