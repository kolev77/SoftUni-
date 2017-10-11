package kolev.springintro.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    private Long id;
    private String name;

    private Set<User> usersBornIn;
    private Set<User> usersLivingIn;

    public Town() {
    }

    public Town(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "bornTown")
    public Set<User> getUsersBornIn() {
        return usersBornIn;
    }

    public void setUsersBornIn(Set<User> usersBornIn) {
        this.usersBornIn = usersBornIn;
    }

    @OneToMany(mappedBy = "currentTown")
    public Set<User> getUsersLivingIn() {
        return usersLivingIn;
    }

    public void setUsersLivingIn(Set<User> usersLivingIn) {
        this.usersLivingIn = usersLivingIn;
    }
}
