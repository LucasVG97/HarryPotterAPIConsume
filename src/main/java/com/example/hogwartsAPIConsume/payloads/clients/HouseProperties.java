package com.example.hogwartsAPIConsume.payloads.clients;

import lombok.Data;

import java.util.List;

@Data
public class HouseProperties {
    private String name;
    private String animal;
    private String founder;
    private List<HouseValue> values;

}
