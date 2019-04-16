package main.rest;

import main.model.*;
import main.service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping("/api/v1/news/")
public class NewsRestController {
    @Autowired
    private SourceService sourceService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentsService commentsService;
//    @Autowired
//    private KindOfSportService kindOfSportService;

    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<News>> get() {
        List<News> news = newsService.getAll();
        return new ResponseEntity<>(news, HttpStatus.OK);

    }
    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(value = "{kindOfSport}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<News>> get2(@PathVariable("kindOfSport") String name) {
        List<News> news =  newsService.getAll();
        List<News> fromCategory = new ArrayList<>();

        for(News n : news) {
            String l = n.getCategory().getKindofsport().getName();
            if(l.startsWith(name))
                fromCategory.add(n);
        }
        Collections.sort(fromCategory, new Comparator<News>() {
            @Override
            public int compare(News lhs, News rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return CompareString(lhs.getPublish_at(),rhs.getPublish_at());
            }
        });

        return new ResponseEntity<>(fromCategory, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(value = "source/{sourceName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Source>> getSource(@PathVariable("sourceName") String name) {
        List<Source> sources = sourceService.getAll();


        return new ResponseEntity<>(sources, HttpStatus.OK);
    }

    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(value = "get/{categoryName}/{sourceName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<News>> getArticleFromCategorySource(@PathVariable("categoryName") String categoryName, @PathVariable("sourceName") String sourceName) {
        List<News> news =  newsService.getAll();
        List<News> fromCategory = new ArrayList<>();

        List<String> sourceNames = Arrays.asList(sourceName.split(","));
        for(News n : news) {
            String l = n.getCategory().getKindofsport().getName();
            if(l.toLowerCase().startsWith(categoryName) && sourceNames.contains(n.getSource().getName().toLowerCase()))
                fromCategory.add(n);
        }
        Collections.sort(fromCategory, new Comparator<News>() {
            @Override
            public int compare(News lhs, News rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return CompareString(lhs.getPublish_at(),rhs.getPublish_at());
            }
        });

        return new ResponseEntity<>(fromCategory, HttpStatus.OK);
    }
    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(value = "getcategory/{categoryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<News>> getSubCategoryFromCategorySource(@PathVariable("categoryName") String categoryName) {
        List<News> news =  newsService.getAll();
        List<News> fromCategory = new ArrayList<>();

        for(News n : news) {
            String l = n.getCategory().getName();
            if(l.startsWith(categoryName))
                fromCategory.add(n);
        }
        Collections.sort(fromCategory, new Comparator<News>() {
            @Override
            public int compare(News lhs, News rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return CompareString(lhs.getPublish_at(),rhs.getPublish_at());
            }
        });


        return new ResponseEntity<>(fromCategory, HttpStatus.OK);
    }

    public  Integer CompareString(String a, String b){
        if(a.equals(" "))
            return  0;
        for (Integer i = 0 ; i < Integer.min(a.length(),b.length()); i++) {
            if(a.charAt(i) > b.charAt(i)) {
                return  -1;
            } if(a.charAt(i) < b.charAt(i))
                return  1;
        }
        return 0;
    }
    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(value = "getarticle/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<News> getSubCategoryFromCategorySource(@PathVariable("id") Long id) {
        List<News> news =  newsService.getAll();

        for(News n : news) {
            if(n.getId().equals(id))
                return new ResponseEntity<>(n, HttpStatus.OK);
        }


        return new ResponseEntity<>(news.get(2), HttpStatus.OK);
    }

    @CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
    @RequestMapping(value = "comments/add/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comments> addComments(@PathVariable("name") String name) {
        String[] ar = name.split("-");
        Comments com =new Comments(ar[0], ar[1],ar[2], newsService.getById(Long.parseLong(ar[3])));

        commentsService.addComment(com);


        return new ResponseEntity<>(com, HttpStatus.OK);
    }


}
