package com.coderscampus.marsroverapiapp.service;

import com.coderscampus.marsroverapiapp.response.MarsRoverApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarsRoverApiService {
    private static final String API_KEY = "reubEGATuM9c6bN2zNEAdvwJwItptOkmxuJ2qczb";

    public MarsRoverApiResponse getRoverData(String roverType, Integer marsSol) {
        RestTemplate rt = new RestTemplate();

        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity(
            "https://api.nasa.gov/mars-photos/api/v1/rovers/" + roverType + 
            "/photos?sol=" + marsSol + "&api_key=" + API_KEY, MarsRoverApiResponse.class);

        return response.getBody();
    }
}
