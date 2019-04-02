package main.service;

import main.model.Category;
import main.model.News;
import main.model.Source;

import java.util.List;

public interface SourceService {
    Source getById(Long id);
    List<Source> getAll();

}
