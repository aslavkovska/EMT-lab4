package mk.ukim.finki.emt.clientmanagement.service.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.username.Username;

@Data
public class ClientForm {
    private String name;
    private String surname;
    private Username username;
    private String email;

}
