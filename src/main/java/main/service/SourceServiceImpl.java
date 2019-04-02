package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.News;
import main.model.Source;
import main.repository.NewsRepository;
import main.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    SourceRepository sourceRepository;

    @Override
    public Source getById(Long id) {
        return sourceRepository.findOne(id);
    }

    @Override
    public List<Source> getAll() {
        return sourceRepository.findAll();
    }
}
