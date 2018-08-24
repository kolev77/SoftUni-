package com.softuni.virus.controllers;

import com.softuni.virus.services.CapitalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private CapitalService capitalService;


    public HomeController(CapitalService capitalService) {
        this.capitalService = capitalService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("message", "Resident Evil home ! ");

        modelAndView.addObject("capitals", this.capitalService.getAllCapitals());

        return modelAndView;
    }


}
