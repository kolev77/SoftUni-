package mvc.filters.demofilters.controllers;

import mvc.filters.demofilters.entities.UserCreateViewModel;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class TestController {

    @GetMapping("/")
    public String index(Model model) {
        UserCreateViewModel viewModel = new UserCreateViewModel() {{
            setUsername("Pesho");
            setPassword("asdasd!!!");
            setCourses(Arrays.asList("Java", "C#", "JS", "DB advanced"));
        }};
        model.addAttribute("model", viewModel);
        model.addAttribute("title", "Index page");

        return "index";
    }

    @GetMapping("/second")
    public String second(Model model) {
        UserCreateViewModel viewModel = new UserCreateViewModel() {{
            setUsername("Goshi");
            setPassword("123123123!!!");
            setCourses(Arrays.asList("MANA MANA", "C#", "TUTU TURURU", "DB advanced"));
        }};

        model.addAttribute("model", viewModel);
        model.addAttribute("title", "Second page");

        return "second";
    }

    @PostMapping("/secured_with_captcha")
    public String secured() {
        return "secured";
    }
}
