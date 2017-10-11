package kolev.spring_intro.services.api;

import kolev.spring_intro.entities.Author;
import kolev.spring_intro.entities.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);

    Category findByName(String name);

    List<Object[]> findProfitByCategory();

    List<Object[]> findRecentBooksByCategories();
}
