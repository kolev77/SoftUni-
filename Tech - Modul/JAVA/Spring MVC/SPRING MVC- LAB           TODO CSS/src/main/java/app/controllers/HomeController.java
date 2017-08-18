package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello";
    }
@RequestMapping("/date")
    public String showDate() {
        return new Date().toString();
    }
}
