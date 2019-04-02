package main.rest;

import main.model.Category;
import main.model.KindOfSport;
import main.model.News;
import main.model.Source;
import main.parser.*;
import main.repository.KindOfSportRepository;
import main.repository.NewsRepository;
import main.repository.SourceRepository;
import main.service.CategoryService;
import main.service.KindOfSportService;
import main.service.NewsService;
import main.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/update/")
public class UpdateRestController {
    @Autowired
    private SourceService sourceService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> update(@PathVariable("id") Long id) {

        Data[] data = { new ParsingFNK()};

        Integer k = 0;

        for (Data p : data) {

            ArrayList<String[]> news = p.getNews();
            for (String[] item : news) {
                try {
                    if(item.length ==5) {
                        News article = new News(item[0], item[1], " ", item[4], item[2], sourceService.getById(p.source_id), categoryService.findByName(item[3]));
                        newsService.save(article);
                        k++;
                    }
                    if(item.length == 4) {
                        News article = new News(item[0], item[1], " ", " ", item[2], sourceService.getById(p.source_id), categoryService.findByName(item[3]));
                        newsService.save(article);
                        k++;
                    }

                } catch (Exception m) {

                }
            }
        }

        return new ResponseEntity<>("" + k, HttpStatus.OK);


    }
}
