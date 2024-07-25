package com.example.demo.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private int studentID;
    private String studentName;
    private int studentAge;
    private String studentPhoneNumber;

}
