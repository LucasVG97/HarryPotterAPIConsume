package com.example.hogwartsAPIConsume.payloads.request;


import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    @NotNull
    private String name;

    @NotNull
    private String grade;

}
