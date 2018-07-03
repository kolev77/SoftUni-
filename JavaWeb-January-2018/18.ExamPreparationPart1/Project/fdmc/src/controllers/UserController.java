package controllers;

import bindingModels.UserLoginBindingModel;
import bindingModels.UserRegisterBindingModel;
import entities.User;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.Controller;
import org.softuni.summer.api.GetMapping;
import org.softuni.summer.api.PostMapping;
import org.softuni.summer.api.PreAuthorize;
import repositories.UserRepository;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
    }


    @PreAuthorize
    @GetMapping(route = "/login")
    public String login(HttpSoletRequest request) {
        return "template:login";
    }

    @PreAuthorize
    @PostMapping(route = "/login")
    public String loginConfirm(HttpSoletRequest request, UserLoginBindingModel userLoginBindingModel) {
        User registeredUser = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        if (registeredUser == null || !registeredUser.getPassword().equals(userLoginBindingModel.getPassword())) {
            return "redirect:/login";
        }

        request.getSession().addAttribute("user-id", registeredUser.getId());
        request.getSession().addAttribute("username", registeredUser.getUsername());

        return "redirect:/";
    }

    @PreAuthorize
    @GetMapping(route = "/register")
    public String register(HttpSoletRequest request) {
        return "template:register";
    }


    @PreAuthorize
    @PostMapping(route = "/register")
    public String registerConfirm(HttpSoletRequest request, UserRegisterBindingModel userRegisterBindingModel) {

        if (!userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            return "redirect:/register";
        }

        if (this.userRepository.findByUsername(userRegisterBindingModel.getUsername()) != null) {
            return "redirect:/register";
        }

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setPassword(userRegisterBindingModel.getPassword());
        user.setEmail(userRegisterBindingModel.getEmail());

        this.userRepository.createUser(user);

        return "redirect:/login";
    }


    @PreAuthorize(loggedIn = true)
    @GetMapping(route = "/logout")
    public String logout(HttpSoletRequest request) {

        request.getSession().invalidate();

        return "redirect:/";
    }
}
