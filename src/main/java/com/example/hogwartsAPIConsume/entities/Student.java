package com.example.hogwartsAPIConsume.entities;

import com.example.hogwartsAPIConsume.payloads.request.StudentRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "grade")
    private String grade;
    @Column(name = "house")
    private UUID houseKey;

    public Student(StudentRequest studentRequest, UUID houseKey) {
        this.name = studentRequest.getName();
        this.grade = studentRequest.getGrade();
        this.houseKey = houseKey;
    }
}
