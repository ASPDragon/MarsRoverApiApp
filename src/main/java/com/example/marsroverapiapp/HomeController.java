package com.example.marsroverapiapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHomeView(ModelMap model) {
//        model.put("name", "Sergei Page");
//        model.put("address", "123, Fake St.");
        return "index";
    }
}
