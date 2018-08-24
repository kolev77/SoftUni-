package com.example.springessentials.controllers;

import com.example.springessentials.objects.Post;
import com.example.springessentials.objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        User user = new User();
        user.setUsername("Georgi");
        user.setPost(new Post() {{
            setName("How to cook rice ? ");
        }});


        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/profile")
    public String getViewProfile(Model model) {
        User user = new User();
        user.setId(5);
        user.setUsername("Gosho");
        user.setCity("Sofia");
        user.setAge(15);

        model.addAttribute("user", user);

        return "view-profile";
    }

    @PostMapping("/profile/{username}")
    public String postProfile(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "profile";
    }

    @PostMapping("/edit/{id}")
    public String postProfile(@ModelAttribute User user, Model model) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("city", user.getCity());
        model.addAttribute("age", user.getAge());

        return "profile";
    }

}
