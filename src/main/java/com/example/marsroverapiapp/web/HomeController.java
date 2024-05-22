package com.example.marsroverapiapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.marsroverapiapp.response.MarsRoverApiResponse;
import com.example.marsroverapiapp.service.MarsRoverApiService;

import io.micrometer.common.util.StringUtils;

@Controller
public class HomeController {
    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView(ModelMap model, @RequestParam(required = false) String marsApiRoverData) {
        // If request param is empty, then set a default value
        if (StringUtils.isEmpty(marsApiRoverData)) {
            marsApiRoverData = "curiosity";
        }

        MarsRoverApiResponse roverData = roverService.getRoverData("curiosity");
        model.put("roverData", roverData);

        return "index";
    }
}
