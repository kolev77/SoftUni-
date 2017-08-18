package soft_uni.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_uni.store.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmailAndAndPassword(String username,String password);
}
