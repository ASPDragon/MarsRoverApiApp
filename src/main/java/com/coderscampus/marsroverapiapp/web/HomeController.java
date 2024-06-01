package com.coderscampus.marsroverapiapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderscampus.dto.HomeDto;
import com.coderscampus.marsroverapiapp.response.MarsRoverApiResponse;
import com.coderscampus.marsroverapiapp.service.MarsRoverApiService;

import io.micrometer.common.util.StringUtils;

@Controller
public class HomeController {
    @Autowired
    private MarsRoverApiService roverService;

    @GetMapping("/")
    public String getHomeView(ModelMap model, HomeDto homeDto) {
        // If request param is empty, then set a default value
        if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())) {
            homeDto.setMarsApiRoverData("curiosity");
        }

        if (homeDto.getMarsSol() == null) {
            homeDto.setMarsSol(1);
        }

        MarsRoverApiResponse roverData = roverService.getRoverData(
            homeDto.getMarsApiRoverData(), homeDto.getMarsSol());
        model.put("roverData", roverData);
        model.put("homeDto", homeDto);

        return "index";
    }
}
