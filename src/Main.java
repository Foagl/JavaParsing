

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Article {
    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Article(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String url;
    private String name;
}
public class Main {


    public static void main(String[] args) throws IOException {
        List<Article> ArticleList = new ArrayList<>();

        Document doc = Jsoup.connect("http://4pda.ru/").get();
        Elements h1Elements = doc.getElementsByAttributeValue("class", "list-post-title");

        h1Elements.forEach(h1Element ->{
              Element aElements = h1Element.child(0);
              String url = aElements.attr("href");
              String title = aElements.child(0).text();
            ArticleList.add(new Article(url, title));
        });
               ArticleList.forEach(System.out::println);
    }}







