package Hiberspring.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    private Long id;
    private String name;
    private Integer clients;
    private Branch branch;


    public Product() {
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

    @Column(name = "clients",nullable = false)
    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    @Column(name = "branch",nullable = false)
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
