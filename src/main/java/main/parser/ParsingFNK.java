package main.parser;

import main.model.Category;
import main.model.KindOfSport;
import main.model.News;
import main.model.Source;
import main.service.CategoryService;
import main.service.KindOfSportService;
import main.service.NewsService;
import main.service.SourceService;
import org.jsoup.Jsoup;

import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public class ParsingFNK extends Data {


    private ArrayList<String[]> news = new ArrayList<String[]>();

    public ParsingFNK() {
        source_id = 1L;
        category_id = 1L;
        categories_name = new String[] {
                "england", "germany","spain", "france", "holland","league", "uefa_cup"};
    }

    @Override
    public ArrayList<String[]> getNews()  {
        try {

            for(String category_name : categories_name) {
                Document document = Jsoup.connect("http://football.kulichki.net/" + category_name).get();
                Elements elements = document.select(".title_r");
                String text = "";

                for (Element el : elements) {
                    try {
                        text = "http://football.kulichki.net"  + el.select("a").attr("href");
                        Document article = Jsoup.connect(text).get();
                        String title = article.select(".title_n").first().text();
                        String description = article.select(".text_n").first().text();
                        String data = article.select(".date_n").first().text();
                        data = data.split(" ")[0] + " "+ data.split(" ")[1];
                        String[] items = {title, description.trim(), text, data, category_name};
                        news.add(items);
                    }
                    catch (Exception e) {

                    }
                }
            }
            return news;
        }
        catch (Exception e) {
            return news;
        }
    }

    public  String showNews() {
        if(news.size() == 0)
            return  "Сломано";
        String answer = "";
        Integer digit = 0;
        for(String[] item : news) {
            answer += digit + "  " + item[0] + " " + " " + item[1]  + " " + item[2] ;
            digit++;
        }
        return answer;
    }
}
