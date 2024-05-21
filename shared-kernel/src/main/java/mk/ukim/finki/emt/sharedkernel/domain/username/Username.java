package mk.ukim.finki.emt.sharedkernel.domain.username;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Username {
    private final String username;

    protected Username(){
        this.username = "";
    }

    public Username(String username){
        this.username = username;
    }

}
