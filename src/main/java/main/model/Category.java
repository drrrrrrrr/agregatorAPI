package main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
public class Category  extends BaseEntity{
    @Column(name = "name_category")
    private String name;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "kindofsport_id", nullable = false)
    private KindOfSport kindofsport;

    public KindOfSport getKindofsport() {
        return this.kindofsport;
    }
    public  Category() {

    }

}
