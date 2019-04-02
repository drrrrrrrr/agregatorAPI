package main.parser;

import main.service.CategoryService;
import main.service.KindOfSportService;
import main.service.NewsService;
import main.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data {
    public  String description;
    public  String title;
    public String date;
    public  String[] tags;
    public String url_img;
    public Long source_id;
    public Long category_id;
    public String[] categories_name;

    public Data() {

    }

    public ArrayList<String[]> getNews() {
        return  new ArrayList<>();
    }

}
