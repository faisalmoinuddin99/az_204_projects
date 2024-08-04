package com.application.azure.controller;

import com.application.azure.config.DataSourceConfig;
import com.application.azure.config.JpaConfig;
import com.application.azure.config.MyProperties;
import com.application.azure.config.ServerConfig;
import com.application.azure.model.Student;
import com.application.azure.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {


    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private final StudentServiceImpl service;
    private final MyProperties properties ;
    private final DataSourceConfig dataSourceConfig;
    private final JpaConfig jpaConfig;
    private final ServerConfig serverConfig ;


    @Autowired
    public StudentController(StudentServiceImpl service, MyProperties properties, ServerConfig config, DataSourceConfig dataSourceConfig, JpaConfig jpaConfig, ServerConfig serverConfig) {
        this.service = service;
        this.properties = properties;
        this.dataSourceConfig = dataSourceConfig;
        this.jpaConfig = jpaConfig;
        this.serverConfig = serverConfig;
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
        log.info("Get students endpoint invoke");
        List<Student> studentList = service.fetchStudents();
        if (studentList.isEmpty()) {
            String errorMessage = "Database is empty";
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorMessage);
        } else {
            log.info("Message received: {}", properties.getMessage());
            return ResponseEntity.ok(studentList);
        }
    }

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student addedStudent = service.addStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(addedStudent);
    }
    @GetMapping("/config")
    public String showConfig() {
        return "DB URL: " + dataSourceConfig.getUrl() +
                ", Hibernate Dialect: " + jpaConfig.getHibernate().getDialect() +
                ", Server Port: " + serverConfig.getPort();
    }

}
