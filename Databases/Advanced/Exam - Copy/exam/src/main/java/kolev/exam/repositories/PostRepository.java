package kolev.exam.repositories;

import kolev.exam.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


    List<Post> findAllByCommentsIsNullOrderByIdAsc();
}
