package com.example.marsroverapiapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.marsroverapiapp.response.MarsRoverApiResponse;
import com.example.marsroverapiapp.service.MarsRoverApiService;

@Controller
public class HomeController {
    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView(ModelMap model) {
        MarsRoverApiResponse roverData = roverService.getRoverData("spirit");
        model.put("roverData", roverData);

        return "index";
    }

    @PostMapping("/")
    public String postHomView(ModelMap model, @RequestParam String marsApiRoverData) {
        MarsRoverApiResponse roverData = roverService.getRoverData(marsApiRoverData);
        model.put("roverData", roverData);

        return "index";
    }
}
