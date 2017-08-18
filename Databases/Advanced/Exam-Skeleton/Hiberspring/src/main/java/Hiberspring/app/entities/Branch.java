package Hiberspring.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "branches")
public class Branch {
    private Long id;
    private String name;
    private Town town;

    public Branch() {
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

    @Column(name = "town",nullable = false)
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
