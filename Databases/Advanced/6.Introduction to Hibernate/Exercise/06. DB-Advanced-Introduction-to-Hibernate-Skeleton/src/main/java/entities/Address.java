package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {
    private Integer id;
    private String text;
    private Town town;
    private Set<Employee> employees;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "address_text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne(cascade = CascadeType.PERSIST) // many addresses joined to one town
    @JoinColumn(name = "town_id",referencedColumnName = "town_id") // we create column with name "town_id" and give it reference to Town.entity(column "town_id")
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @OneToMany(mappedBy = "address",fetch = FetchType.EAGER)   // One address joined to many employees.
    public Set<Employee> getEmployees() {  // We must map not by column name, but by property name "address".
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
