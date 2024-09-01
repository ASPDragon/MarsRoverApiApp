package com.coderscampus.marsroverapiapp.service;

import com.coderscampus.marsroverapiapp.response.MarsRoverApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class MarsRoverApiService {
    private static String NASA_API_KEY;

    static {
        try {
            String envContent = new String(Files.readAllBytes(Paths.get(".env")));
            String[] lines = envContent.split("\n");
            for (String line : lines) {
                String[] parts = line.split("=");
                if (parts.length == 2 && parts[0].trim().equals("NASA_API_KEY")) {
                    NASA_API_KEY = parts[1].trim();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read NASA_API_KEY from .env file", e);
        }
    }

    public MarsRoverApiResponse getRoverData(String roverType, Integer marsSol) {
        if (NASA_API_KEY == null) {
            throw new IllegalStateException("NASA_API_KEY environment variable is not set.");
        }

        RestTemplate rt = new RestTemplate();

        ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity(
            "https://api.nasa.gov/mars-photos/api/v1/rovers/" + roverType + 
            "/photos?sol=" + marsSol + "&api_key=" + NASA_API_KEY, MarsRoverApiResponse.class);

        return response.getBody();
    }
}
