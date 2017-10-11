package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.regex.Pattern;

@Entity
@Table(name = "visitations")
public class Visitation {
    private Long id;
    private Date date;
    private String comments;

    private Patient patient;

    public Visitation() {
    }

    public Visitation(Date date, String comments) {
        this.date = date;
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

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
