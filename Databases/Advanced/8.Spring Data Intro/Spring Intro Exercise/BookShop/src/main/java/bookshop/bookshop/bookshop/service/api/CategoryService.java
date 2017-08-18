package bookshop.bookshop.bookshop.service.api;

import java.util.List;
import java.util.Set;

public interface CategoryService<Category, Long> extends ServiceInterface<Category, Long> {
    void save(Category category);

    Set<Category> categoriesByName(List<String> categories);

    List<Object[]> findTotalProfitByCategory();
    List<Category> findAllCategoriesOrderByBookCount();
}