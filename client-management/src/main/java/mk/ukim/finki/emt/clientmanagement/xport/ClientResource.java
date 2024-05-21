package mk.ukim.finki.emt.clientmanagement.xport;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.clientmanagement.domain.model.Client;
import mk.ukim.finki.emt.clientmanagement.domain.model.ClientId;
import mk.ukim.finki.emt.clientmanagement.service.ClientService;
import mk.ukim.finki.emt.clientmanagement.service.form.ClientForm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientResource {
    private final ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable("id") ClientId clientId) {
        return clientService.findById(clientId);
    }

    @PostMapping("/create")
    public void createClient(@RequestBody ClientForm clientForm, HttpServletResponse response) throws IOException{
        clientService.createClient(clientForm);
        response.sendRedirect("/api/clients");
    }

    @PutMapping("/{id}")
    public void updateClient(@PathVariable("id") ClientId clientId, @RequestBody ClientForm clientForm, HttpServletResponse response) throws IOException{
        clientService.updateClient(clientId, clientForm);
        response.sendRedirect("/api/clients");
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") ClientId clientId, HttpServletResponse response) throws IOException{
        clientService.deleteClient(clientId);
        response.sendRedirect("/api/clients");
    }
}
