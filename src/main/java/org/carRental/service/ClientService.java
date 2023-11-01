package org.carRental.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.carRental.execption.ClientNotFoundException;
import org.carRental.execption.ValidationException;
import org.carRental.model.Client;
import org.carRental.repository.ClientRepository;

@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(Client client) {
        if (client.getName().isEmpty())
            throw new ValidationException("Name", "Client name cannot be empty");
        return clientRepository.registerClient(client);
    }

    public void deleteClient(Integer clientId) {
        if (clientId == null)
            throw new ValidationException("id", "id cannot be empty");
        clientRepository.removeById(clientId);
    }

    public void updateClient(Client client) {
        if (client.getId() == null)
            throw new ValidationException("id", "id cannot be empty");
        clientRepository.modifyClient(client).orElseThrow(() -> new ClientNotFoundException("Client with the given id does not exist"));
    }
}
