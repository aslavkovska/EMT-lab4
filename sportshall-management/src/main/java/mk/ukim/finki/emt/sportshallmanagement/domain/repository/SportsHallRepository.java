package mk.ukim.finki.emt.sportshallmanagement.domain.repository;

import mk.ukim.finki.emt.sportshallmanagement.domain.model.SportsHall;
import mk.ukim.finki.emt.sportshallmanagement.domain.model.SportsHallId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsHallRepository extends JpaRepository<SportsHall, SportsHallId> {
}
