import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false, length = 60)
    private String passwordHash;

    @Column(length = 100)
    private String fullName;


    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<Post>();

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
