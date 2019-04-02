package main.repository;

import main.model.Customer;
import main.model.KindOfSport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KindOfSportRepository extends JpaRepository<KindOfSport, Long> {
}
