package mk.ukim.finki.emt.trainingmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDate;

@Embeddable
@Getter
public class DateOfBirth {
    private final LocalDate date_of_birth;

    protected DateOfBirth(){
        this.date_of_birth = LocalDate.now();
    }
    public DateOfBirth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
