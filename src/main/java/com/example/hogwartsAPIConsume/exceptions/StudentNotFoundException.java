package com.example.hogwartsAPIConsume.exceptions;

import java.util.UUID;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id){
        super("Student with Id " + id + " not found!");
    }
}
