package main.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParsingChampinatFootball extends Data{
    Map<String, String> categories_nameDic;

    public ParsingChampinatFootball() {
        source_id = 4L;
        category_id = 1L;
        categories_name = new String[]{
                "spain","germany", "spain", "france"};
        categories_nameDic = new HashMap<String, String>();
        categories_nameDic.put("england", "_england.html");
        categories_nameDic.put("germany", "_germany.html");
        categories_nameDic.put("spain", "_spain.html");
        categories_nameDic.put("france", "_france.html");
    }
    private ArrayList<String[]> news = new ArrayList<String[]>();
    @Override
    public ArrayList<String[]> getNews()  {
        try {

            for(String category_name : categories_name) {
                Document document = Jsoup.connect("https://www.championat.com/football/" +categories_nameDic.get(category_name)).
                        userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
                Elements elements = document.select(".news-item__content");
                String text = "";
                String title= "";
                String description="";
                for (Element el : elements) {
                    try {
                        text = "https://www.championat.com" + el.select("a").attr("href");
                        Document article = Jsoup.connect(text).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
                        title = article.select(".article-head__title").first().text();

                        description = article.select(".article-content").first().text();
                        String[] dataArray = article.select(".article-head__date").first().attr("content").split("T");
                        dataArray[1] = dataArray[1].split("\\+")[0];
                        String data =String.join(" ", dataArray);
//                        data = " ";
                        String url_img = " ";
                        try {
                            url_img = article.select(".article-head__photo > img").first().attr("src");
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
