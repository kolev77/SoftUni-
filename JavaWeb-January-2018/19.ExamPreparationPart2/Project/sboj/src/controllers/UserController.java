package controllers;

import bindingModel.UserLoginBindingModel;
import bindingModel.UserRegisterBindingModel;
import entities.User;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.Controller;
import org.softuni.summer.api.GetMapping;
import org.softuni.summer.api.PostMapping;
import repositories.UserRepository;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();

    }

    private boolean isLoggedIn(HttpSoletRequest request) {
        return request.getSession().getAttributes().containsKey("user-id");
    }


    @GetMapping(route = "/login")
    public String login(HttpSoletRequest request) {
        if (!this.isLoggedIn(request)) {
            return "template:login";
        }
        return "redirect:/home";
    }

    @PostMapping(route = "/login")
    public String loginConfirm(HttpSoletRequest request, UserLoginBindingModel bindingModel) {
        if (this.isLoggedIn(request)) {
            return "redirect:/home";
        }

        User registeredUser = this.userRepository.findByUsername(bindingModel.getUsername());

        if (registeredUser == null || !registeredUser.getPassword().equals(bindingModel.getPassword())) {
            return "redirect:/login";
        }
        request.getSession().addAttribute("user-id",
                registeredUser.getId());
        request.getSession().addAttribute("username",
                registeredUser.getUsername());

        return "redirect:/home";
    }

    @GetMapping(route = "/register")
    public String register(HttpSoletRequest request) {
        if (!this.isLoggedIn(request)) {
            return "template:register";
        }
        return "redirect:/home";
    }

    @PostMapping(route = "/register")
    public String registerConfirm(HttpSoletRequest request, UserRegisterBindingModel bindingModel) {
        if (this.isLoggedIn(request)) {
            return "template:home";
        }

        if (!bindingModel.getPassword().equals(bindingModel.getConfirmPassword())) {
            return "redirect:/register";
        }

        User user = new User();

        user.setUsername(bindingModel.getUsername());
        user.setPassword(bindingModel.getPassword());
        user.setEmail(bindingModel.getEmail());

        this.userRepository.createUser(user);

        return "redirect:/login";


    }

    @GetMapping(route = "/logout")
    public String logout(HttpSoletRequest request) {
        if (!this.isLoggedIn(request)) {
            return "redirect:/login";
        }

        request.getSession().invalidate();

        return "redirect:/";
    }


}
