package main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "source")
@Getter
@Setter
@ToString
public class Source  extends BaseEntity{
   

    @Column(name = "name_source")
    private String name;

    public Source() {
    }
//
//    public Source(String name) {
//        this.name = name;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
