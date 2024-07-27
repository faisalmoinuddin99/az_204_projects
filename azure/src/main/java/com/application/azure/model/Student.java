package com.application.azure.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;

    @Column(name = "student_name", length = 20, nullable = false)
    private String studentName;

    @Column(name = "student_age", length = 21)
    private int age;
}
