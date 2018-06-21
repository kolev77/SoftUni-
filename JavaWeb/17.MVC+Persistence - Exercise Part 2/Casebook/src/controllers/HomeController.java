package controllers;

import bindingModels.UserBindingModel;
import org.softuni.summer.api.*;
import repository.KittyRepository;

@Controller
public class HomeController {
    @GetMapping(route = "/")
    public String index() {
        return "template:index";
    }

    @PostMapping(route = "/create/{id}")
    public String create(UserBindingModel bindingModel, @PathVariable long id, Model model) {
        return "redirect:/loggedin";
    }

    @GetMapping(route = "/loggedin")
    public String loggedin(Model model) {
        StringBuilder kittensResult = new StringBuilder();

        for (String s : new KittyRepository().getKittens()) {
            kittensResult.append("<h2>" + s + "</h2>");
        }

        model.addAttribute("kittens", kittensResult.toString());

        return "template:loggedin";
    }

    @GetMapping(route = "/delete/{id}")
    public String delete(Model model, @PathVariable long id) {
        model.addAttribute("bachka", "BACHKA SI KATO PICH");

        return "template:delete";
    }

    @GetMapping(route = "/delete/pesho")
    public String deletePesho(){
        return "THIS IS PESHO DELETE";
    }
}
