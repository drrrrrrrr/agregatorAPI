package main.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParsingBloodMMA extends Data{
    Map<String, String> categories_nameDic;

    public ParsingBloodMMA() {
        source_id = 5L;
        category_id = 1L;
        categories_name = new String[]{
                "UFC","bellator"};
        categories_nameDic = new HashMap<String, String>();
        categories_nameDic.put("bellator", "bellator");
        categories_nameDic.put("UFC", "ufc");

    }
    private ArrayList<String[]> news = new ArrayList<String[]>();
    @Override
    public ArrayList<String[]> getNews()  {
        try {
//http://bloodandsweat.ru/tags/" + categories_nameDic.get(category_name
            for(String category_name : categories_name) {
                Document document = Jsoup.connect("http://bloodandsweat.ru/tags/" + categories_nameDic.get(category_name))
                        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
                Elements elements = document.select("h2");
                String text = "";
                String title= "";
                String description="";
                for (Element el : elements) {
                    try {
                        text =  el.select("a").attr("href");
                        Document article = Jsoup.connect(text).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
                        title = article.select(".content-block-title-wrap").first().text();
                        description = article.select(".content_wrap").first().text();
//                        String data =article.select(".article-head__date").first().text();
                        String data ="";
//                        data = " ";
                        String url_img = article.select(".size-full").first().attr("src");
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
            String a = "sasa";
//            return news;
        }
        return news;

    }
}
