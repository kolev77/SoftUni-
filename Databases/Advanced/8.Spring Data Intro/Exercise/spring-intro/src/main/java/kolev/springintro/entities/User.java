package kolev.springintro.entities;

import kolev.springintro.validators.Password;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private byte[] profilePicture;
    private Date registeredOn;
    private Date lastTimeLoggedIn;
    private Integer age;
    private Boolean isDeleted;

    private Town bornTown;
    private Town currentTown;

    private String firstName;
    private String lastName;

    private Set<User> friends;

    public User() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() < 4 || username.length() > 30) {
            throw new IllegalArgumentException("Username length should be between 4 and 30 symbols");
        }
        this.username = username;
    }

    @Column(name = "password")
    @Password(containsDigit = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (!email.matches("^[a-zA-z0-9]+[\\w.-]+[a-zA-z0-9]+@[a-zA-z]+[a-zA-Z.]+[a-zA-z]+$")) {
            throw new IllegalArgumentException("Invalid email !");
        }

        this.email = email;
    }

    @Column(name = "profile_picutre", columnDefinition = "LONGBLOB")
    public byte[] getProfilePicture() {
        return profilePicture;
    }


    public void setProfilePicture(byte[] profilePicture) {
//        if (profilePicture.length > 1024 * 1024) {
//            throw new IllegalArgumentException("Picture is too big !");
//        }
        this.profilePicture = profilePicture;
    }

    @Column(name = "registered_on")
    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_logged_in")
    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column(name = "age",nullable = false)
    //@Size(min = 1,max = 120,message = "Invalid age !")
    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
//        if (age < 1 || age > 120) {
//            throw new IllegalArgumentException("Invalid age.");
//        }
        this.age = age;
    }

    @Column(name = "is_deleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne
    @JoinColumn(name = "born_town_id",referencedColumnName = "id")
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne
    @JoinColumn(name = "current_town_id",referencedColumnName = "id")
    public Town getCurrentTown() {
        return currentTown;
    }

    public void setCurrentTown(Town currentlyTown) {
        this.currentTown = currentlyTown;
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

    @Transient
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    @ManyToMany
    @JoinTable(name = "user_friends",
    joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "friend_id",referencedColumnName = "id"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
