package mk.ukim.finki.emt.trainingmanagement.domain.model;

import jakarta.persistence.*;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.trainingmanagement.domain.valueobjects.DateOfBirth;
import mk.ukim.finki.emt.trainingmanagement.domain.valueobjects.SportsHallId;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "trainer")
public class Trainer extends AbstractEntity<TrainerId> {
    private String name;
    private String surname;
    private DateOfBirth date_of_birth;
    private int years_experience;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Appointment> appointmentList;

    public Trainer(){
        super(DomainObjectId.randomId(TrainerId.class));
        this.appointmentList = new HashSet<>();
    }

    public Trainer(String name, String surname, DateOfBirth date_of_birth, int years_experience){
        super(DomainObjectId.randomId(TrainerId.class));
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.years_experience = years_experience;
        this.appointmentList = new HashSet<>();
    }

    public void addAppointment(@NonNull SportsHallId sportsHallId, @NonNull TrainerId trainerId, LocalDateTime date, int duration_hours){
        Objects.requireNonNull(sportsHallId, "Sports Hall must not be null");
        Objects.requireNonNull(trainerId, "Trainer must not be null");
        appointmentList.add(new Appointment(sportsHallId, trainerId, date, duration_hours, null));
    }

    public void removeAppointment(@NonNull AppointmentId appointmentId){
        Objects.requireNonNull(appointmentId, "Appointment must not be null");
        appointmentList.removeIf(a->a.getId().equals(appointmentId));
    }

}
