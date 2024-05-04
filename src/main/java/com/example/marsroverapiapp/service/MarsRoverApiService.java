package com.example.marsroverapiapp.service;

import com.example.marsroverapiapp.response.MarsRoverApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarsRoverApiService {
    public MarsRoverApiResponse getRoverData() {
        RestTemplate rt = new RestTemplate();
        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=nvhWBLej0XW9KGq9gQD1kbLd4SLDIasE7dkUg64I";

        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity(url, MarsRoverApiResponse.class);

        return response.getBody();
    }
}
