package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private String profession;

    @Column(name = "sector")
    private JobApplicationSector sector;

    @Column(nullable = false)
    private Double salary;
    @Column(nullable = false)
    private String description;

    public JobApplication() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public JobApplicationSector getSector() {
        return sector;
    }

    public void setSector(JobApplicationSector sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("<div class=\"col-md-3 mb-4 d-flex flex-column text-center\">")
                .append("<img src=\"" + JobApplicationSector.getSimpleValue(this.getSector())
                        + ".jpg\" class=\"img-thumbnail\" width=\"300\" height=\"300\">")
                .append("<h5 class=\"text-center\">" + this.getProfession() + "</h5>")
                .append("<a href=\"/jobs/details/" + this.getId() + "\"class=\"btn btn-info\">Details</a>")
                .append("<a href=\"/jobs/delete/" + this.getId() + "\"class=\"btn btn-danger\">Delete</a>")
                .append("</div");

        return result.toString();
    }
}
