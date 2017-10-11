package kolev.spring_intro.repositories;

import kolev.spring_intro.entities.Author;
import kolev.spring_intro.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    Category findByName(String name);

    @Query("SELECT c.name,sum (b.copies*b.price) FROM Category AS c INNER JOIN c.books AS b group by c.name order by sum (b.copies * b.price) desc, c.name asc")
    List<Object[]> findProfitByCategory();

    @Query("select c.name, b.title from Category as c inner join c.books as b where b.id in (select b.id from Book inner join b.categories as bc where bc.id = c.id order by b.releaseDate desc limit 3)")
    List<Object[]> findRecentBooksByCategories();
}


