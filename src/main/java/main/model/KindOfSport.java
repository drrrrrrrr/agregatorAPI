package main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "kindofsport")
@Getter
@Setter
@ToString
public class KindOfSport extends BaseEntity{

    @Column(name = "name_kindofsport")
    private String name;

    public KindOfSport() {
    }
//
//    public KindOfSport(String name) {
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
        return this.name;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
