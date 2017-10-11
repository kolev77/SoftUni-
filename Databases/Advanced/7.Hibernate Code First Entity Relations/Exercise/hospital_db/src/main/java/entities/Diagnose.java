package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diagnoses")
public class Diagnose {
    private Long id;
    private String name;
    private String comments;

    private Patient patient;
    public Diagnose() {
    }

    public Diagnose(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
