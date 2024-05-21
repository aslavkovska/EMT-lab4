package mk.ukim.finki.emt.sportshallmanagement.service.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.address.Address;

@Data
public class SportsHallForm {
    private String name;
    private Address address;
    private String phone_number;
}
