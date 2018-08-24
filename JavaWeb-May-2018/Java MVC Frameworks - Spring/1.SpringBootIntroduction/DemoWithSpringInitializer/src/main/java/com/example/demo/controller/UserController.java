package com.example.demo.controller;

import com.example.demo.model.view.UserCreateRequestModel;
import com.example.demo.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register(Model model) {
        model.addAttribute("viewModel", new UserCreateRequestModel());
        return "users/register";
    }


    @PostMapping("/users/register")
    public String registerConfirm(UserCreateRequestModel viewModel, Model model) {
        if (this.userService.register(viewModel.getUsername(),viewModel.getPassword())){
            return "redirect:/";
        }

        model.addAttribute("viewModel", viewModel);
        return "users/register";
    }
}
