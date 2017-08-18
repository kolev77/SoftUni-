package bookshop.bookshop.bookshop.service.impl;

import bookshop.bookshop.bookshop.dao.api.CategoryDao;
import bookshop.bookshop.bookshop.model.Category;
import bookshop.bookshop.bookshop.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    @Autowired
    private CategoryDao dao;

    @Override
    public Category findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Category object) {
        dao.delete(object);
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Category object) {
        dao.save(object);
    }


    @Override
    public Set<Category> categoriesByName(List<String> categories) {
        return this.dao.categoriesByName(categories);
    }

    @Override
    public List<Object[]> findTotalProfitByCategory() {
        return this.dao.findTotalProfitByCategory();
    }

    @Override
    public List<Category> findAllCategoriesOrderByBookCount() {
        return this.dao.findAllCategoriesOrderByBookCount();
    }
}