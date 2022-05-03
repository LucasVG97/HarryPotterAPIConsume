package com.example.hogwartsAPIConsume.payloads.response;

import com.example.hogwartsAPIConsume.entities.Student;
import com.example.hogwartsAPIConsume.payloads.clients.HouseProperties;
import com.example.hogwartsAPIConsume.payloads.request.StudentRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse extends StudentRequest {

    private Long id;
    private HouseProperties house;

    public StudentResponse(Student student){
        this.setId(student.getId());
        this.setName(student.getName());
        this.setGrade(student.getGrade());
    }

}
