package com.example.hogwartsAPIConsume.services.impl;

import com.example.hogwartsAPIConsume.clients.HousePropertiesClient;
import com.example.hogwartsAPIConsume.clients.SortingHatClient;
import com.example.hogwartsAPIConsume.entities.Student;
import com.example.hogwartsAPIConsume.exceptions.StudentNotFoundException;
import com.example.hogwartsAPIConsume.payloads.clients.HouseProperties;
import com.example.hogwartsAPIConsume.payloads.request.StudentRequest;
import com.example.hogwartsAPIConsume.payloads.response.StudentResponse;
import com.example.hogwartsAPIConsume.repositories.StudentRepository;
import com.example.hogwartsAPIConsume.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final HousePropertiesClient housePropertiesClient;
    private final SortingHatClient sortingHatClient;
    private final StudentRepository studentRepository;


    @Override
    public Student create(StudentRequest studentRequest) {

        Student student = new Student(studentRequest, sortingHatClient.sort().getKey());
        return studentRepository.save(student);
    }

    @Override
    public StudentResponse findById(Long id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        HouseProperties houseProperties = housePropertiesClient.getHouseProps(student.getHouseKey());
        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setHouse(houseProperties);
        return studentResponse;
    }
}
