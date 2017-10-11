package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthdate;
    private byte[] picture;
    private boolean insurence;

    Set<Visitation> visitations;
    Set<Diagnose> diagnoses;
    Set<Medicament> prescribedMedicaments;

    public Patient() {
    }

    public Patient(String firstName, boolean insurence, Set<Visitation> visitations, Set<Diagnose> diagnoses, Set<Medicament> prescribedMedicaments) {
        this.firstName = firstName;
        this.insurence = insurence;
        this.visitations = visitations;
        this.diagnoses = diagnoses;
        this.prescribedMedicaments = prescribedMedicaments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "is_insurenced")
    public boolean isInsurence() {
        return insurence;
    }

    public void setInsurence(boolean insurence) {
        this.insurence = insurence;
    }

    @OneToMany(mappedBy = "patient")
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @OneToMany(mappedBy = "patient")
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @ManyToMany(mappedBy = "patients")
    public Set<Medicament> getPrescribedMedicaments() {
        return prescribedMedicaments;
    }

    public void setPrescribedMedicaments(Set<Medicament> prescribedMedicaments) {
        this.prescribedMedicaments = prescribedMedicaments;
    }
}
