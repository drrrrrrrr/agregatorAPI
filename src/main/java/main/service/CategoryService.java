package main.service;

import main.model.Category;

import java.util.List;

public interface CategoryService {
     Category findByName(String name_category);
     List<Category> getAll();
}
