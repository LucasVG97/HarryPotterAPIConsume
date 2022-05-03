package com.example.hogwartsAPIConsume.payloads.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class HouseKey {
    @JsonProperty("sorting-hat-choice")
    private UUID key;
}
