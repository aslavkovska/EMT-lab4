package mk.ukim.finki.emt.clientmanagement.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt.clientmanagement.domain.model.Client;
import mk.ukim.finki.emt.clientmanagement.domain.model.ClientId;
import mk.ukim.finki.emt.clientmanagement.domain.exceptions.ClientIdNotFoundException;
import mk.ukim.finki.emt.clientmanagement.domain.repository.ClientRepository;
import mk.ukim.finki.emt.clientmanagement.service.ClientService;
import mk.ukim.finki.emt.clientmanagement.service.form.ClientForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(ClientId clientId) {
        return clientRepository.findById(clientId).orElseThrow(ClientIdNotFoundException::new);
    }

    @Override
    public ClientId createClient(ClientForm clientForm) {
        var client = new Client(clientForm.getName(), clientForm.getSurname(), clientForm.getUsername(), clientForm.getEmail());
        return clientRepository.saveAndFlush(client).getId();
    }

    @Override
    public Client updateClient(ClientId clientId, ClientForm clientForm) {
        var client = this.findById(clientId);
        client.updateClient(clientForm.getName(), clientForm.getSurname(), clientForm.getUsername(), clientForm.getEmail());
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(ClientId clientId) {
        clientRepository.deleteById(clientId);
        clientRepository.flush();
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
