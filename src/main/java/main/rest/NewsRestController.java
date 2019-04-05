package main.rest;

import main.model.Category;
import main.model.Client;
import main.model.News;
import main.model.Source;
import main.service.CategoryService;
import main.service.NewsService;
import main.service.SourceService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/news/")
public class NewsRestController {
    @Autowired
    private SourceService sourceService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<News>> get() {

//       List<News> news =  newsService.getAll();
        List<News> news = newsService.getAll();
//
//        List<JSONObject> entities = new ArrayList<JSONObject>();
//        for (News n : news) {
//            JSONObject entity = new JSONObject();
////            entity.put("aaa", "bbb");
////            entity.put("bbb", "ccc");
//
//            entities.add(entity);
//        }
        return new ResponseEntity<>(news, HttpStatus.OK);

    }
    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get2(@PathVariable("id") Long id) {

//       List<News> news =  newsService.getAll();

//
//        List<JSONObject> entities = new ArrayList<JSONObject>();
//        for (News n : news) {
//            JSONObject entity = new JSONObject();
////            entity.put("aaa", "bbb");
////            entity.put("bbb", "ccc");
//
//            entities.add(entity);
//        }
        return new ResponseEntity<>("" + id, HttpStatus.OK);

    }

}
