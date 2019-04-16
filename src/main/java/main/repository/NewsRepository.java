package main.repository;

import main.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Query("select news from News news where news.title = :title")
    News findByName(@Param("title") String title);
}
