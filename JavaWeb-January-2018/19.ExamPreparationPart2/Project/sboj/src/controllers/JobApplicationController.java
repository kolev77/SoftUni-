package controllers;


import bindingModel.JobApplicationAddBindingModel;
import entities.JobApplication;
import entities.JobApplicationSector;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summer.api.*;
import repositories.JobApplicationRepository;

@Controller
public class JobApplicationController {
    private JobApplicationRepository jobApplicationRepository;

    public JobApplicationController() {
        this.jobApplicationRepository = new JobApplicationRepository();
    }

    private boolean isLoggedIn(HttpSoletRequest request) {
        return request.getSession().getAttributes().containsKey("user-id");
    }

    @GetMapping(route = "/jobs/add")
    public String addJob(HttpSoletRequest request) {
        if (!this.isLoggedIn(request)) {
            return "redirect:/login";
        }
        return "template:add-job";
    }

    @PostMapping(route = "/jobs/add")
    public String addJobConfirm(HttpSoletRequest request, JobApplicationAddBindingModel bindingModel) {
        if (!this.isLoggedIn(request)) {
            return "redirect:/";
        }

        JobApplication jobApplication = new JobApplication();
        jobApplication.setSector(JobApplicationSector.parseValue(bindingModel.getSector()));
        jobApplication.setProfession(bindingModel.getProfession());
        jobApplication.setSalary(bindingModel.getSalary());
        jobApplication.setDescription(bindingModel.getDescription());

        this.jobApplicationRepository.createJobApplication(jobApplication);

        return "redirect:/home";
    }


    @GetMapping(route = "/jobs/details/{id}")
    public String details(@PathVariable String id, HttpSoletRequest request, Model model) {
        if (!this.isLoggedIn(request)) {
            return "redirect:/login";
        }

        JobApplication jobApplication = this.jobApplicationRepository.findById(id);

        if (jobApplication == null) {
            return "redirect:/home";
        }

        model.addAttribute("sector", jobApplication.getSector());
        model.addAttribute("profession", jobApplication.getProfession());
        model.addAttribute("salary", jobApplication.getSalary());
        model.addAttribute("description", jobApplication.getDescription());
        model.addAttribute("id", jobApplication.getId());

        return "template:job-details";
    }


    @GetMapping(route = "/jobs/delete/{id}")
    public String deleteJob(@PathVariable String id, HttpSoletRequest request, Model model) {
        System.out.println("get mapping works");
        if (!this.isLoggedIn(request)) {
            System.out.println("Please log in ! ");
            return "redirect:/login";
        }
        System.out.println("id = " + id );
        JobApplication jobApplication = this.jobApplicationRepository.findById(id);


        if (jobApplication == null) {
            return "redirect:/home";
        }

        System.out.println(jobApplication.getId());
        System.out.println(jobApplication.getProfession());

        model.addAttribute("sector", jobApplication.getSector());
        model.addAttribute("profession", jobApplication.getProfession());
        model.addAttribute("salary", jobApplication.getSalary());
        model.addAttribute("description", jobApplication.getDescription());
        model.addAttribute("id", jobApplication.getId());
        return "template:delete-job";
    }


    @PostMapping(route = "/jobs/delete/{id}")
    public String deleteJobConfirm(@PathVariable String id, HttpSoletRequest request) {
        if (!this.isLoggedIn(request)) {
            return "redirect:/login";
        }

        JobApplication jobApplicationToDelete = this.jobApplicationRepository.findById(id);
        System.out.println(jobApplicationToDelete.getSector());
        System.out.println();

        this.jobApplicationRepository.deleteById(id);

        return "redirect:/home";
    }


}

