package softuni.users.entities;

import softuni.users.validators.Password;

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
    private boolean isDeleted;

    private Town bornTown;
    private Town currentlyLivingInTown;

    private String firstName;
    private String lastName;

    private Set<User> friends;
    private Set<Album> albums;

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
            throw new IllegalArgumentException("Username length should be between 4 and 30 symbols.");
        }
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    @Password(containsDigit = true, containsLowercase = true)
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
        if (!email.matches("^[a-zA-Z0-9]+[\\w.-]+[a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z.]+[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        this.email = email;
    }

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
//        if (profilePicture.length > 1024*1024){
//            throw new IllegalArgumentException("Picture is too big.");
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

    @Column(name = "last_time_logged_in")
    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "is_deleted")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne  // many people to one city
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne  // many people to one city
    @JoinColumn(name = "living_in_town_id", referencedColumnName = "id")
    public Town getCurrentlyLivingInTown() {
        return currentlyLivingInTown;
    }

    public void setCurrentlyLivingInTown(Town currentlyLivingInTown) {
        this.currentlyLivingInTown = currentlyLivingInTown;
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
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)  // It must be "cascade.ALL" because of the new users added in our set of friends. They must be saved before adding them to our set of friends/
    @JoinTable(name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL) // One user has many albums mapped by album`s field -> owner
    public Set<Album> getAlbums() {
        return this.albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
