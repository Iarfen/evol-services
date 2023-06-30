package com.evolServices.controller;

import com.evolServices.dao.ClientsDAO;
import com.evolServices.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class ClientsController {
    
    @Autowired
    private ClientsDAO clientsDAO;

    /**
     * GET request. Returns all clients
     * @return A list of all clients
     */
    @GetMapping("/clients")
    public List<Client> getClients() {
        return (List<Client>) clientsDAO.findAll();
    }

    /**
     * GET request. Returns the requested client
     * @param clientId
     * @return The client of the given id
     * @throws ResponseStatusException
     */
    @GetMapping("/clients/{clientId}")
    public Client getClient(@PathVariable Long clientId) throws ResponseStatusException {
        return clientsDAO.findById(clientId).orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"); } );
    }

    /**
     * POST request. Creates a new client
     * @param client
     */
    @PostMapping("/clients")
    void addClient(@RequestBody Client client) {
        clientsDAO.save(client);
    }

    /**
     * PUT request. Updates a client
     * @param client
     * @param clientId
     * @throws ResponseStatusException
     */
    @PutMapping("/clients/{clientId}")
    void putClient(@RequestBody Client client,@PathVariable Long clientId) throws ResponseStatusException {
        Optional<Client> dbClient = clientsDAO.findById(clientId);
        if (dbClient.isPresent())
        {
            client.setId(clientId);
            clientsDAO.save(client);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    /**
     * DELETE request. Deletes the client of the given id
     * @param clientId
     * @throws ResponseStatusException
     */
    @DeleteMapping("/clients/{clientId}")
    void deleteClient(@PathVariable Long clientId) throws ResponseStatusException {
        Optional<Client> dbClient = clientsDAO.findById(clientId);
        if (dbClient.isPresent())
        {
            clientsDAO.deleteById(clientId);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }
}
