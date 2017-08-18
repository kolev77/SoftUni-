package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "Hello");
        model.addAttribute("date", new Date().toString());
        // TODO: find all users from DB
        return "hello-view";
    }

    @RequestMapping("/numbers")
    public String numbers() {
        return "numbers";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }
}
