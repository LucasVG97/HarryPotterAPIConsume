package com.example.hogwartsAPIConsume.controllers;

import com.example.hogwartsAPIConsume.entities.Student;
import com.example.hogwartsAPIConsume.payloads.request.StudentRequest;
import com.example.hogwartsAPIConsume.payloads.response.StudentResponse;
import com.example.hogwartsAPIConsume.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student create(@RequestBody StudentRequest studentRequest){
        return studentService.create(studentRequest);
    }

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public StudentResponse findById(@PathParam("id") Long id){
        return studentService.findById(id);
    }
}
