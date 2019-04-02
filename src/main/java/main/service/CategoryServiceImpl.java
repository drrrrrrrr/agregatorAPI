package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.Category;
import main.repository.CategoryRepository;
import main.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category findByName(String name_category) {
        return categoryRepository.findByName(name_category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
