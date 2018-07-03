package entities.institutions;

import entities.positions.Chief;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "administrations")
public class Administration {
    private Long id;
    private Set<Department> departments;
    private Chief chief;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "administration", cascade = CascadeType.PERSIST)
    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "head_of_administration")
    public Chief getChief() {
        return chief;
    }

    public void setChief(Chief chief) {
        this.chief = chief;
    }
}
