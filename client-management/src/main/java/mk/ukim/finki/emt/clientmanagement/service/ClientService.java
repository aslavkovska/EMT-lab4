package mk.ukim.finki.emt.clientmanagement.service;

import mk.ukim.finki.emt.clientmanagement.domain.model.Client;
import mk.ukim.finki.emt.clientmanagement.domain.model.ClientId;
import mk.ukim.finki.emt.clientmanagement.service.form.ClientForm;

import java.util.List;

public interface ClientService {

    Client findById(ClientId clientId);
    ClientId createClient(ClientForm clientForm);
    Client updateClient(ClientId clientId, ClientForm clientForm);
    void deleteClient(ClientId clientId);
    List<Client> getAll();
}
