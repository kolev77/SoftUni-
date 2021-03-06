package softuni.softuni.entities;

import javax.persistence.*;

@Entity
@Table(name = "accessories")
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessory_id")
    private long id;

    @Column(name = "accessory_name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "accessory_owner_id")
    private Photographer accessoryOwner;

    public Accessory() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photographer getAccessoryOwner() {
        return this.accessoryOwner;
    }

    public void setAccessoryOwner(Photographer accessoryOwner) {
        this.accessoryOwner = accessoryOwner;
    }
}