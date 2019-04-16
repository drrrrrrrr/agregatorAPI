package main.service;

import main.model.Category;
import main.model.News;

import java.util.ArrayList;
import java.util.List;

public interface NewsService {
    News getById(Long id);
    void save(News news);
    void save(ArrayList<News> news);
    List<News> getAll();
    News findByName(String name_news);
}
