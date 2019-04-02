package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.KindOfSport;
import main.model.News;
import main.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Override
    public News getById(Long id) {
        return newsRepository.findOne(id);
    }

    @Override
    public void save(News news) {
        this.newsRepository.save(news);
    }

    @Override
    public void save(ArrayList<News> news) {
        this.newsRepository.save(news);
    }

    @Override
    public List<News> getAll() {
        return this.newsRepository.findAll();
    }
}
