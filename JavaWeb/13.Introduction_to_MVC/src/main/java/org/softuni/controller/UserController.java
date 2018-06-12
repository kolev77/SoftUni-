package org.softuni.controller;

import org.softuni.model.UserRegisterViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/users/register")
    public String register(Model model) {
        UserRegisterViewModel user = new UserRegisterViewModel();
//        user.setUsername("Pesho");

        model.addAttribute("viewModel", user);
        return "users/register";
    }


    @PostMapping("/users/register")
    public String register(@ModelAttribute UserRegisterViewModel bindingModel,
                           Model model,
                           BindingResult result) {
        bindingModel.setUsername(
                bindingModel.getUsername() + "Edited"
        );
        model.addAttribute("viewModel", bindingModel);

        return "users/register";
    }
}
