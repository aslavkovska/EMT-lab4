package mk.ukim.finki.emt.trainingmanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.trainingmanagement.domain.valueobjects.ClientId;
import mk.ukim.finki.emt.trainingmanagement.domain.valueobjects.SportsHallId;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "appointment")
public class Appointment extends AbstractEntity<AppointmentId> {
    public LocalDateTime date;
    public int duration_hours;

    @AttributeOverride(name = "id", column = @Column(name = "sportshall_id", nullable = false))
    private SportsHallId sportsHallId;

    @AttributeOverride(name = "id", column = @Column(name = "trainer_id", nullable = false))
    private TrainerId trainerId;

    @AttributeOverride(name = "id", column = @Column(name = "client_id"))
    private ClientId clientId;
//    private List<ClientId> clientIds;

    public Appointment(){
        super(DomainObjectId.randomId(AppointmentId.class));
//        this.clientIds = new ArrayList<>();
    }

    public Appointment(@NonNull SportsHallId sportsHallId, @NonNull TrainerId trainerId, @NonNull LocalDateTime date, @NonNull int duration_hours, ClientId clientId){
        super(DomainObjectId.randomId(AppointmentId.class));
        this.sportsHallId = sportsHallId;
        this.trainerId = trainerId;
        this.date = date;
        this.duration_hours = duration_hours;
        this.clientId = clientId;
//        this.clientIds = new ArrayList<>();
    }
}
