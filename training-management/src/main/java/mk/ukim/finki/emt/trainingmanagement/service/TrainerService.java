package mk.ukim.finki.emt.trainingmanagement.service;

import mk.ukim.finki.emt.trainingmanagement.domain.exceptions.AppointmentIdNotFoundException;
import mk.ukim.finki.emt.trainingmanagement.domain.exceptions.TrainerIdNotFoundException;
import mk.ukim.finki.emt.trainingmanagement.domain.model.AppointmentId;
import mk.ukim.finki.emt.trainingmanagement.domain.model.Trainer;
import mk.ukim.finki.emt.trainingmanagement.domain.model.TrainerId;
import mk.ukim.finki.emt.trainingmanagement.service.forms.AppointmentForm;
import mk.ukim.finki.emt.trainingmanagement.service.forms.TrainerForm;

import java.util.List;

public interface TrainerService {
    TrainerId placeTrainer(TrainerForm trainerForm);
    List<Trainer> findAll();
    Trainer findById(TrainerId trainerId);
    void addAppointment(TrainerId trainerId, AppointmentForm appointmentForm) throws TrainerIdNotFoundException;
    void deleteAppointment(TrainerId trainerId, AppointmentId appointmentId) throws TrainerIdNotFoundException, AppointmentIdNotFoundException;
}
