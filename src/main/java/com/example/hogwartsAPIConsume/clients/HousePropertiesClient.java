package com.example.hogwartsAPIConsume.clients;

import com.example.hogwartsAPIConsume.payloads.clients.HouseProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class HousePropertiesClient {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Value("https://api-harrypotter.herokuapp.com/house/")
    private String housePropertiesURL;

    public HouseProperties getHouseProps (UUID houseKey){
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<HouseProperties> housePropertiesResponse = restTemplate.exchange(
                housePropertiesURL + houseKey,
                HttpMethod.GET,
                entity,
                HouseProperties.class
        );

        if (housePropertiesResponse.getStatusCode().isError()){
            throw new HttpClientErrorException(housePropertiesResponse.getStatusCode());
        }
        return housePropertiesResponse.getBody();
    }

}
