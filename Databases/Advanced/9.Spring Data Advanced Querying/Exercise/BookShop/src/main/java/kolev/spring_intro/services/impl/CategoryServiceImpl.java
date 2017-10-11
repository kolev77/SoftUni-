package kolev.spring_intro.services.impl;

import kolev.spring_intro.entities.Category;
import kolev.spring_intro.repositories.CategoryRepository;
import kolev.spring_intro.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Object[]> findProfitByCategory() {
        return categoryRepository.findProfitByCategory();
    }

    @Override
    public List<Object[]> findRecentBooksByCategories() {
        return categoryRepository.findRecentBooksByCategories();
    }
}
