package controllers;

import bindingModels.KittenCreateBindingModel;
import entities.Kitten;
import entities.KittenBreed;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.*;
import repositories.KittenRepository;

@Controller
public class KittenController {
    private KittenRepository kittenRepository;


    public KittenController() {
        this.kittenRepository = new KittenRepository();
    }


    @PreAuthorize(loggedIn = true)
    @GetMapping(route = "/kittens/all")
    public String allKittens(HttpSoletRequest request, Model model) {
        Kitten[] allKittens = this.kittenRepository.allKittens();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < allKittens.length; i++) {
            Kitten currentKitten = allKittens[i];
            if (i == 0) {
                result.append("<div class=\"row\"> ")
                        .append(currentKitten.toString());
            } else if (i % 3 == 0) {
                result.append("</div>")
                        .append("<div class=\"row\">")
                        .append(currentKitten.toString());
            } else {
                result.append(currentKitten.toString());
            }
        }
        if (allKittens.length % 3 != 0) {
            result.append("</div>");
        }


        model.addAttribute("allkittens", result);

        return "template:all-kittens";
    }



    @PreAuthorize(loggedIn = true)
    @GetMapping(route = "/kittens/add")
    public String addKitten(HttpSoletRequest request) {
        return "template:add-kitten";
    }

    @PreAuthorize(loggedIn = true)
    @PostMapping(route = "/kittens/add")
    public String addKittenConfirm(HttpSoletRequest request, KittenCreateBindingModel kittenCreateBindingModel) {


        Kitten kitten = new Kitten();
        kitten.setName(kittenCreateBindingModel.getName());
        kitten.setAge(kittenCreateBindingModel.getAge());
        kitten.setBreed(KittenBreed.parseValue(kittenCreateBindingModel.getBreed()));

        this.kittenRepository.createKitten(kitten);

        return "redirect:/kittens/all";
    }
}
