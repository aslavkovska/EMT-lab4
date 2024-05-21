package mk.ukim.finki.emt.sportshallmanagement.service;

import mk.ukim.finki.emt.sportshallmanagement.domain.model.SportsHall;
import mk.ukim.finki.emt.sportshallmanagement.domain.model.SportsHallId;
import mk.ukim.finki.emt.sportshallmanagement.service.form.SportsHallForm;

import java.util.List;

public interface SportsHallService {
    SportsHall findById(SportsHallId sportsHallId);
    SportsHallId createSportsHall(SportsHallForm sportsHallForm);
    SportsHall updateSportsHall(SportsHallId sportsHallId, SportsHallForm sportsHallForm);
    void deleteSportsHall(SportsHallId sportsHallId);
    List<SportsHall> getAll();
}
