package tatun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tatun.model.Category;
import tatun.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(int id) {
        Optional<Category> optional = categoryRepository.findById(id);
        return optional.get();
    }

    public void delete(Category category) {
        categoryRepository.delete(category);

    }
}
