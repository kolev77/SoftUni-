package hiberspring.hiberspring.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    private Long id;
    private String name;
    private Integer population;
    private Set<Branch> branches;

    public Town() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "population",nullable = false)
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
