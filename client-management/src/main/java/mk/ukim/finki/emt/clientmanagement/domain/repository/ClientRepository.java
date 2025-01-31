package mk.ukim.finki.emt.clientmanagement.domain.repository;

import mk.ukim.finki.emt.clientmanagement.domain.model.Client;
import mk.ukim.finki.emt.clientmanagement.domain.model.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, ClientId> {
}
