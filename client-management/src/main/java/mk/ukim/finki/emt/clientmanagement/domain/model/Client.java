package mk.ukim.finki.emt.clientmanagement.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.username.Username;

import java.util.Objects;


@Entity
@Table(name = "client")
@Getter
public class Client extends AbstractEntity<ClientId> {
    private String name;
    private String surname;
    private Username username;
    private String email;

    public Client(){
        super(DomainObjectId.randomId(ClientId.class));
    }

    public Client(String name, String surname, Username username, String email){
        super(DomainObjectId.randomId(ClientId.class));
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }

    public void updateClient(String name, String surname, Username username, String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }

    public int hashCode(){
        return Objects.hash(super.hashCode(), name, surname, username, email);
    }
}
