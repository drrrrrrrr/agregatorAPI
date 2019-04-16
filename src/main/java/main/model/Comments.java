package main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
public class Comments extends BaseEntity {
    @Column(name = "description")
    private String description;
//    public void setDescription(String descr) {
//        this.description = descr;
//    }
    public String getDateComment() {
        return  dateComment;
    }
//    public void setDateComment(String date) {
//        this.dateComment = date;
//    }

    @Column(name = "dateComment")
    private String dateComment;

    @Column(name = "email")
    private String email;

    public  String getEmail() {
        return  this.email;
    }
//    public  void  setEmail(String name) {
//        this.email = name;
//    }


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "news_id", nullable = false)
    private News news;

    public News getNews() {
        return this.news;
    }
//    public void  setNews(News n) {
//        this.news = n;
//    }
    public  Comments() {

    }
    public Comments( String email, String description, String dateComment, News news) {
        this.description = description;
        this.dateComment = dateComment;
        this.email = email;
        this.news = news;

    }
    public String getDescription() {
        return description;
    }

}
