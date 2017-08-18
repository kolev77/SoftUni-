package hiberspring.hiberspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee_cards")
public class EmployeeCard {
    private Long id;
    private String number;

    public EmployeeCard() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "number",nullable = false)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
