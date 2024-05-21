package mk.ukim.finki.emt.sportshallmanagement.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.emt.sharedkernel.domain.address.Address;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.username.Username;

import java.util.Objects;

@Entity
@Table(name = "sportshall")
public class SportsHall extends AbstractEntity<SportsHallId> {
    public String name;
    public Address address;
    public String phone_number;

    public SportsHall(){
        super(DomainObjectId.randomId(SportsHallId.class));
    }

    public SportsHall(String name, Address address, String phone_number){
        super(DomainObjectId.randomId(SportsHallId.class));
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    public void updateSportsHall(String name, Address address, String phone_number) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    public int hashCode(){
        return Objects.hash(super.hashCode(), name, address, phone_number);
    }
}
