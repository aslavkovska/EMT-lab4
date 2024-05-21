package mk.ukim.finki.emt.trainingmanagement.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt.trainingmanagement.domain.exceptions.AppointmentIdNotFoundException;
import mk.ukim.finki.emt.trainingmanagement.domain.exceptions.TrainerIdNotFoundException;
import mk.ukim.finki.emt.trainingmanagement.domain.model.AppointmentId;
import mk.ukim.finki.emt.trainingmanagement.domain.model.Trainer;
import mk.ukim.finki.emt.trainingmanagement.domain.model.TrainerId;
import mk.ukim.finki.emt.trainingmanagement.domain.repository.TrainerRepository;
import mk.ukim.finki.emt.trainingmanagement.service.TrainerService;
import mk.ukim.finki.emt.trainingmanagement.service.forms.AppointmentForm;
import mk.ukim.finki.emt.trainingmanagement.service.forms.TrainerForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public TrainerId placeTrainer(TrainerForm trainerForm) {
        Objects.requireNonNull(trainerForm, "Trainer must not be null");
        var newTrainer = trainerRepository.saveAndFlush(toDomainObject(trainerForm));
        return newTrainer.getId();
    }

    private Trainer toDomainObject(TrainerForm trainerForm){
        var trainer = new Trainer(trainerForm.getName(), trainerForm.getSurname(), trainerForm.getDateOfBirth(), trainerForm.getYears_experience());
        trainerForm.getAppointments().forEach(appointment -> trainer.addAppointment(appointment.getSportsHallId(), appointment.getTrainerId(), appointment.getDate(), appointment.getDuration_hours()));
        return trainer;
    }

    @Override
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer findById(TrainerId trainerId) {
        return trainerRepository.findById(trainerId).orElseThrow(TrainerIdNotFoundException::new);
    }

    @Override
    public void addAppointment(TrainerId trainerId, AppointmentForm appointmentForm) throws TrainerIdNotFoundException {
        Trainer trainer = this.findById(trainerId);
        trainer.addAppointment(appointmentForm.getSportsHallId(), appointmentForm.getTrainerId(), appointmentForm.getDate(), appointmentForm.getDuration_hours());
        trainerRepository.saveAndFlush(trainer);
    }

    @Override
    public void deleteAppointment(TrainerId trainerId, AppointmentId appointmentId) throws TrainerIdNotFoundException, AppointmentIdNotFoundException {
        Trainer trainer = this.findById(trainerId);
        trainer.removeAppointment(appointmentId);
        trainerRepository.saveAndFlush(trainer);
    }
}
