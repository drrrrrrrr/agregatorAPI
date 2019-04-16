package main.repository;


import main.model.KindOfSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KindOfSportRepository extends JpaRepository<KindOfSport, Long> {

//    @Query("select kindOfSport from KindOfSport kindOfSport where kindOfSport.name = :name_kindOfSport")
//    KindOfSport findByName(@Param("name_category") String name_kindOfSport);
}
