package com.example.hogwartsAPIConsume.clients;

import com.example.hogwartsAPIConsume.payloads.clients.HouseKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class SortingHatClient {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Value("https://api-harrypotter.herokuapp.com/sortinghat")
    private String sortHatURL;

    public HouseKey sort(){

        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<HouseKey> houseKeyResponse = restTemplate.exchange(
                sortHatURL,
                HttpMethod.GET,
                entity,
                HouseKey.class
        );

        if (houseKeyResponse.getStatusCode().isError()){
            throw new HttpClientErrorException(houseKeyResponse.getStatusCode());
        }

        return houseKeyResponse.getBody();
    }

}
