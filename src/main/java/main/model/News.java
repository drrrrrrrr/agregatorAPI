package main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "news")
@Getter
@Setter
@ToString
public class News extends BaseEntity{


    @Column(name = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "url_to_source")
    private String url_to_source;

    public String getUrl_to_source() {
        return this.url_to_source;
    }
    public void setUrl_to_source(String url_to_source) {
        this.url_to_source = url_to_source;
    }

    @Column(name = "url_img")
    private String url_img;

    public String getUrl_img() {
        return this.url_img;
    }
    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    @Column(name = "publish_at")
    private String publish_at;

    public String getPublish_at() {
        return this.publish_at;
    }
    public void setPublish_at(String publish_at) {
        this.publish_at = publish_at;
    }


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public News(String title, String description, String url_to_source,
                  String url_img, String publish_at, Source source , Category category) {
        this.title = title;
        this.description = description;
        this.url_to_source = url_to_source;
        this.url_img = url_img;
        this.publish_at = publish_at;
        this.source = source;
        this.category = category;
    }
    public News() {

    }

    public Category getCategory() {
        return this.category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public Source getSource() {
        return this.source;
    }
    public void setSource(Category category) {
        this.source = source;
    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Source getBank() {
//        return source;
//    }
//
//    public void setBank(Source source) {
//        this.source = source;
//    }

}
