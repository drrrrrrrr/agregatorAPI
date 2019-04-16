package main.parser;

import com.sun.tools.javac.util.ArrayUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class ParsingVseNaBox extends Data{
    Map<String, String> categories_nameDic;

    public ParsingVseNaBox() {
        source_id = 6L;
        category_id = 1L;
        categories_name = new String[]{
                "box"};
        categories_nameDic = new HashMap<String, String>();
        categories_nameDic.put("box", "box");

    }
    private ArrayList<String[]> news = new ArrayList<String[]>();
    @Override
    public ArrayList<String[]> getNews()  {
        try {

            for(String category_name : categories_name) {
                Document document = Jsoup.connect("http://vsenabox.ru/news/" ).
                        userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
                Elements elements = document.select(".item_news");
                String text = "";
                String title= "";
                String description="";
                for (Element el : elements) {
                    try {
                        String data = " ";
                        try {
                            String[] dataArray = el.select(".date").first().text().split("\\.");
                            data  = dataArray[2]+ "-" + dataArray[1] +"-"+dataArray[0];
                        }
                        catch (Exception e) {

                        }

                        text = "http://vsenabox.ru" + el.select("a").attr("href");
                        Document article = Jsoup.connect(text).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
                        title = article.select(".post__body > .h3").first().text();

                        description = article.select(".post__body").first().text();
//                        data = " ";
                        String url_img = " ";
                        try {
                            url_img ="http://vsenabox.ru" +  article.select(".post__avatar > img").first().attr("src");
                        }
                        catch (Exception e) {

                        }
                        String[] items = {title, description.trim(), text , data, category_name, url_img};
                        news.add(items);
                    }
                    catch (Exception e) {
                        String m  ="";
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
