package mk.ukim.finki.emt.trainingmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.username.Username;

@Getter
public class Client implements ValueObject {

    private final ClientId id;
    private final String name;
    private final String surname;
    private final Username username;
    private final String email;

    private Client(){
        this.id = ClientId.randomId(ClientId.class);
        this.name = "";
        this.surname = "";
        this.username = new Username("");
        this.email = "";
    }

    @JsonCreator
    public Client(ClientId id, String name, String surname, Username username, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }
}
