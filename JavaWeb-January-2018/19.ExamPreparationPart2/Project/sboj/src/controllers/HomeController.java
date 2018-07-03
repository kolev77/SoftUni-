package controllers;


import entities.JobApplication;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.Controller;
import org.softuni.summer.api.GetMapping;
import org.softuni.summer.api.Model;
import repositories.JobApplicationRepository;

import java.util.List;

@Controller
public class HomeController {
    private JobApplicationRepository jobApplicationRepository;

    public HomeController() {
        this.jobApplicationRepository = new JobApplicationRepository();
    }

    private boolean isLoggedIn(HttpSoletRequest request) {
        return request.getSession().getAttributes().containsKey("user-id");
    }

    @GetMapping(route = "/")
    public String index(HttpSoletRequest request) {
        if (this.isLoggedIn(request)) {
            return "redirect:/home";
        }
        return "template:index";
    }

    @GetMapping(route = "/home")
    public String home(HttpSoletRequest request, Model model) {
        if (!this.isLoggedIn(request)) {
            return "redirect:/";
        }

        model.addAttribute("username",
                request.getSession().getAttributes().get("username"));

        List<JobApplication> allJobs = this.jobApplicationRepository.findAll();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < allJobs.size(); i++) {
            JobApplication currentJobApplication = allJobs.get(i);
            if (i == 0) {
                result.append("<div class=\"row d-flex justify-content-around\">")
                        .append(currentJobApplication.toString());
            } else if (i % 3 == 0) {
                result.append("</div>");
                result.append("<div class=\"row d-flex justify-content-around\">")
                        .append(currentJobApplication.toString());
            } else {
                result.append(currentJobApplication.toString());
            }
        }

        if (!allJobs.isEmpty()) result.append("</div>");

        model.addAttribute("jobApplications", result.toString());
        return "template:home";
    }


}
