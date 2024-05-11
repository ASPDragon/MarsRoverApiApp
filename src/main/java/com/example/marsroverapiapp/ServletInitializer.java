package com.example.marsroverapiapp;

import com.example.marsroverapiapp.response.MarsRoverApiResponse;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MarsRoverApiAppApplication.class);
    }
}
