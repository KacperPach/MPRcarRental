package org.carRental.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.carRental.model.Car;
import org.carRental.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor

public class ClientRepository {

    private static Logger logger = LogManager.getLogger(CarRepository.class);

    @Getter
    private  List<Client> clientList = new ArrayList<>();

    public Optional<Client> getById(Integer id){
        return clientList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    //dodanie
    public Client registerClient(Client client) {
        logger.info("Registered client: " + client);
        client.setId(clientList.size());
        clientList.add(client);
        return client;
    }
    //aktualizacja
    public Optional<Client> modifyClient(Client client) {
        logger.info("Modified client: " + client);
        Optional<Client> clientToModify = getById(client.getId());

        return clientToModify.map(it -> {
            it.setName(client.getName());
            it.setRentedCarId(client.getRentedCarId());
            return it;
        });
    }
    //usuniecie

    public void removeById(Integer clientId) {
        logger.info("Removed Client: " + clientId);
        Optional<Client> client = getById(clientId);
        client.ifPresent(it -> clientList.remove(it));
    }

}
