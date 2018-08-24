package com.softuni.virus.controllers;

import com.softuni.virus.models.service.CapitalServiceModel;
import com.softuni.virus.models.view.AddVirusViewModel;
import com.softuni.virus.services.CapitalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VirusController {
    private CapitalService capitalService;

    public VirusController(CapitalService capitalService) {
        this.capitalService = capitalService;
    }

    @GetMapping("/add")
    public ModelAndView addVirus(ModelAndView modelAndView) {
        modelAndView.setViewName("add-virus");

        AddVirusViewModel viewModel = new AddVirusViewModel();
        for (CapitalServiceModel capitalServiceModel : this.capitalService.getAllCapitals()) {
            viewModel.getCapitals().add(capitalServiceModel.getName());
        }
        modelAndView.addObject("model", viewModel);

        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView showViruses(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        return modelAndView;
    }

}
