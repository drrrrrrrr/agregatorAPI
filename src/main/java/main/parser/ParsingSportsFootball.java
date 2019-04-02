package main.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParsingSportsFootball extends Data {
    Map<String, String> categories_nameDic;
    public ParsingSportsFootball() {
        source_id = 3L;
        category_id = 1L;
        categories_name = new String[] {
                "england"};
        categories_nameDic = new HashMap<String, String>();
        categories_nameDic.put("england", "england");
        categories_nameDic.put("germany", "germany");
        categories_nameDic.put("spain", "spain");
        categories_nameDic.put("france", "france");

    }

    private ArrayList<String[]> news = new ArrayList<String[]>();
    @Override
    public ArrayList<String[]> getNews()  {
        try {

            for(String category_name : categories_name) {
                Document document = Jsoup.connect("https://www.sports.ru/football/" +categories_nameDic.get(category_name)).get();
                Elements elements = document.select("a.h2");
                String text = "";

                for (Element el : elements) {
                    try {
                        text = el.select("a").attr("href");
                        Document article = Jsoup.connect(text).get();
                        String title = article.select("h1").first().text();
                        String description = article.select(".material-item__content").first().text();
                        String data = article.select(".blog-post__header__date").first().text();
//                        String url_img = article.select(".node-content__logo > a").first().attr("href");
                        String[] items = {title, description.trim(), data, category_name};
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
}
