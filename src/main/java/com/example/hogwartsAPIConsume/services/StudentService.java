package com.example.hogwartsAPIConsume.services;

import com.example.hogwartsAPIConsume.entities.Student;
import com.example.hogwartsAPIConsume.payloads.request.StudentRequest;
import com.example.hogwartsAPIConsume.payloads.response.StudentResponse;

import java.util.UUID;

public interface StudentService {
    Student create(StudentRequest studentRequest);
    StudentResponse findById(Long id);
}
