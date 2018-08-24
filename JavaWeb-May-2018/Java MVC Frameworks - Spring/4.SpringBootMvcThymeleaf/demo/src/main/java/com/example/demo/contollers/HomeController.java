package com.example.demo.contollers;

import com.example.demo.dtos.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("date", new Date());
        List<String> daysofWeek = new ArrayList<>() {{
            add("Monday");
            add("Tuesday");
            add("Wednesday");
            add("Thursday");
            add("Friday");
            add("Saturday");
            add("Sunday");
        }};

        String agentWhiskey = "Jack Daniels";

        model.addAttribute("agentName", agentWhiskey);
        model.addAttribute("daysOfWeek", daysofWeek);

        return "index";
    }


    @GetMapping("/register")
    public String register(@ModelAttribute UserDTO userDTO) {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e-> System.out.println(e.getDefaultMessage()));
            return "register";
        }

        System.out.println(userDTO.getUsername());
        System.out.println(userDTO.getPassword());
        return "redirect:/";
    }


}
