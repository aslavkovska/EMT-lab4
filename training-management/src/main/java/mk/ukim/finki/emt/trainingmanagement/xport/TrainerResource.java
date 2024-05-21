package mk.ukim.finki.emt.trainingmanagement.xport;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.trainingmanagement.domain.model.AppointmentId;
import mk.ukim.finki.emt.trainingmanagement.domain.model.Trainer;
import mk.ukim.finki.emt.trainingmanagement.domain.model.TrainerId;
import mk.ukim.finki.emt.trainingmanagement.service.TrainerService;
import mk.ukim.finki.emt.trainingmanagement.service.forms.AppointmentForm;
import mk.ukim.finki.emt.trainingmanagement.service.forms.TrainerForm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/trainer")
@AllArgsConstructor
public class TrainerResource {
    private final TrainerService trainerService;

    @GetMapping
    public List<Trainer> findAll(){
        return trainerService.findAll();
    }

    @GetMapping("/{id}")
    public Trainer findById(@PathVariable TrainerId trainerId){
        return trainerService.findById(trainerId);
    }

    @PostMapping("/create")
    public void createTrainer(@RequestBody TrainerForm trainerForm, HttpServletResponse response) throws IOException{
        trainerService.placeTrainer(trainerForm);
        response.sendRedirect("/api/trainer");
    }

    @PostMapping("/{id}/addAppointment")
    public void addAppointment(@PathVariable TrainerId trainerId, @RequestBody AppointmentForm appointmentForm, HttpServletResponse response) throws IOException {
        trainerService.addAppointment(trainerId, appointmentForm);
        response.sendRedirect("/api/trainer");
    }

    @PostMapping("/{id}/deleteAppointment")
    public void deleteAppointment(@PathVariable TrainerId trainerId, @RequestBody AppointmentId appointmentId, HttpServletResponse response) throws IOException {
        trainerService.deleteAppointment(trainerId, appointmentId);
        response.sendRedirect("/api/trainer");
    }
}
