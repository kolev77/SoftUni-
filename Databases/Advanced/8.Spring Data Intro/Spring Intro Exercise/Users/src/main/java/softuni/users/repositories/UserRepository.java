package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.users.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u.username, u.email from User as u where u.email like concat('%', :provider)")
    List<Object[]> findUsersByEmailProvider(@Param("provider") String provider);
}
