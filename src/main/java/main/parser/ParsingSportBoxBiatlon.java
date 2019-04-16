package main.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParsingSportBoxBiatlon extends Data {
    Map<String, String> categories_nameDic;
    public ParsingSportBoxBiatlon() {
        source_id = 2L;

        categories_name = new String[] {
                "biatlon"};
        categories_nameDic = new HashMap<String, String>();
        categories_nameDic.put("biatlon", "Biatlon");


    }

    private ArrayList<String[]> news = new ArrayList<String[]>();
    @Override
    public ArrayList<String[]> getNews()  {
        try {
            for(String category_name : categories_name) {
                Document document = Jsoup.connect("https://news.sportbox.ru/Vidy_sporta/" +categories_nameDic.get(category_name)).get();
                Elements elements = document.select("._Sportbox_Spb2015_Components_TeazerBlock_TeazerBlock");
                String text = "";

                for (Element el : elements) {
                    try {
                        text = "https://news.sportbox.ru" + el.select("a").attr("href");
                        Document article = Jsoup.connect(text).get();
                        String title = article.select(".node-header__title").first().text();
                        String description = article.select(".js-mediator-article").first().text();
                        Elements oo =   article.getElementsByTag("meta");
                        String year =  "";
                        for(Element a : oo) {
                            if(a.attr("itemprop").startsWith("dateCreated")) {
                                year = a.attr("content");
                            }
                        }
                        String data = article.select(".b-author__date").first().text();
                        data = year + " " + data.split(" ")[data.split(" ").length - 1];
                        String url_img = article.select(".node-content__logo > a").first().attr("href");
                        String[] items = {title, description.trim(), text, data, category_name, url_img};
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
