package com.example.marsroverapiapp;

import com.example.marsroverapiapp.response.MarsRoverApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MarsRoverApiTest {
    @Test
    public void smallTest() {
        RestTemplate rt = new RestTemplate();

        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=nvhWBLej0XW9KGq9gQD1kbLd4SLDIasE7dkUg64I";
        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity(url, MarsRoverApiResponse.class);
        System.out.println(response.getBody());
    }
}
