package mk.ukim.finki.emt.sportshallmanagement.xport;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sportshallmanagement.domain.model.SportsHall;
import mk.ukim.finki.emt.sportshallmanagement.domain.model.SportsHallId;
import mk.ukim.finki.emt.sportshallmanagement.service.SportsHallService;
import mk.ukim.finki.emt.sportshallmanagement.service.form.SportsHallForm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/sportshall")
@AllArgsConstructor
public class SportsHallResource {
    private final SportsHallService sportsHallService;

    @GetMapping
    public List<SportsHall> findAll(){
        return sportsHallService.getAll();
    }

    @GetMapping("/{id}")
    public SportsHall findById(@PathVariable("id") SportsHallId sportsHallId) {
        return sportsHallService.findById(sportsHallId);
    }

    @PostMapping("/create")
    public void createSportsHall(@RequestBody SportsHallForm sportsHallForm, HttpServletResponse response) throws IOException {
        sportsHallService.createSportsHall(sportsHallForm);
        response.sendRedirect("/api/sportshall");
    }

    @PutMapping("/{id}")
    public void updateSportsHall(@PathVariable("id") SportsHallId sportsHallId, @RequestBody SportsHallForm sportsHallForm, HttpServletResponse response) throws IOException{
        sportsHallService.updateSportsHall(sportsHallId, sportsHallForm);
        response.sendRedirect("/api/sportshall");
    }

    @DeleteMapping("/{id}")
    public void deleteSportsHall(@PathVariable("id") SportsHallId sportsHallId, HttpServletResponse response) throws IOException{
        sportsHallService.deleteSportsHall(sportsHallId);
        response.sendRedirect("/api/sportshall");
    }
}
