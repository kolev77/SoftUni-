package kolev.exam.repositories;

import kolev.exam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);


    @Query("SELECT u FROM User as u where u.posts.size >0")
    List<User> findUsersWithPostsAndComments();
}
