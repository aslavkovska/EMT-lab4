package mk.ukim.finki.emt.trainingmanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.trainingmanagement.domain.model.TrainerId;
import mk.ukim.finki.emt.trainingmanagement.domain.valueobjects.ClientId;
import mk.ukim.finki.emt.trainingmanagement.domain.valueobjects.SportsHallId;

import java.time.LocalDateTime;

@Data
public class AppointmentForm {
    private LocalDateTime date;
    private int duration_hours;
    private SportsHallId sportsHallId;
    private TrainerId trainerId;
    private ClientId clientId;
}
