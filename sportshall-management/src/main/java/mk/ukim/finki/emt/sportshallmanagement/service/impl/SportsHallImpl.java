package mk.ukim.finki.emt.sportshallmanagement.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt.sportshallmanagement.domain.exceptions.SportsHallIdNotFoundException;
import mk.ukim.finki.emt.sportshallmanagement.domain.model.SportsHall;
import mk.ukim.finki.emt.sportshallmanagement.domain.model.SportsHallId;
import mk.ukim.finki.emt.sportshallmanagement.domain.repository.SportsHallRepository;
import mk.ukim.finki.emt.sportshallmanagement.service.SportsHallService;
import mk.ukim.finki.emt.sportshallmanagement.service.form.SportsHallForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SportsHallImpl implements SportsHallService {

    private final SportsHallRepository sportsHallRepository;

    public SportsHallImpl(SportsHallRepository sportsHallRepository) {
        this.sportsHallRepository = sportsHallRepository;
    }

    @Override
    public SportsHall findById(SportsHallId sportsHallId) {
        return sportsHallRepository.findById(sportsHallId).orElseThrow(SportsHallIdNotFoundException::new);
    }

    @Override
    public SportsHallId createSportsHall(SportsHallForm sportsHallForm) {
        var sportsHall = new SportsHall(sportsHallForm.getName(), sportsHallForm.getAddress(), sportsHallForm.getPhone_number());
        return sportsHallRepository.saveAndFlush(sportsHall).getId();
    }

    @Override
    public SportsHall updateSportsHall(SportsHallId sportsHallId, SportsHallForm sportsHallForm) {
        var sportsHall = findById(sportsHallId);
        sportsHall.updateSportsHall(sportsHallForm.getName(), sportsHallForm.getAddress(), sportsHallForm.getPhone_number());
        return sportsHallRepository.saveAndFlush(sportsHall);
    }

    @Override
    public void deleteSportsHall(SportsHallId sportsHallId) {
        sportsHallRepository.deleteById(sportsHallId);
        sportsHallRepository.flush();
    }

    @Override
    public List<SportsHall> getAll() {
        return sportsHallRepository.findAll();
    }
}
