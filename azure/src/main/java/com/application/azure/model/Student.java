package com.application.azure.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    private int studentID ;
    private String studentName ;
    private String studentPhoneNumber ;
    private int age ;
}
