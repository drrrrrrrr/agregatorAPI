package main.repository;

import main.model.Comments;
import main.model.KindOfSport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
