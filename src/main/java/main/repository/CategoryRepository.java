package main.repository;

import main.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select category from Category category where category.name = :name_category")
    Category findByName(@Param("name_category") String name_category);

}
