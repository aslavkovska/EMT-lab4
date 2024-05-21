package mk.ukim.finki.emt.trainingmanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.trainingmanagement.domain.valueobjects.DateOfBirth;
import java.util.HashSet;
import java.util.Set;

@Data
public class TrainerForm {
    private String name;
    private String surname;
    private DateOfBirth dateOfBirth;
    private int years_experience;
    private Set<AppointmentForm> appointments = new HashSet<>();
}
