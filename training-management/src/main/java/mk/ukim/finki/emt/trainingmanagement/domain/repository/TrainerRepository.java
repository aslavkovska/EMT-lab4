package mk.ukim.finki.emt.trainingmanagement.domain.repository;

import mk.ukim.finki.emt.trainingmanagement.domain.model.Trainer;
import mk.ukim.finki.emt.trainingmanagement.domain.model.TrainerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, TrainerId> {
}
