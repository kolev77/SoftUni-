package kolev.automapping.entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    private Long id;
    private City city;

    public Address() {
    }

    public Address(City city) {
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
