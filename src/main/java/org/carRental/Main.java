package org.carRental;

import org.carRental.model.Car;
import org.carRental.model.Client;
import org.carRental.model.types.Availability;
import org.carRental.model.types.CarCategory;
import org.carRental.repository.CarRepository;
import org.carRental.repository.ClientRepository;
import org.carRental.service.CarService;
import org.carRental.service.ClientService;

public class Main {
    public static void main(String[] args) {
        CarService cas = new CarService(new CarRepository());
        cas.create(new Car("VW", "Golf", "11111111111111111", CarCategory.F, Availability.AVAILABLE));
        cas.updateCar(new Car(0,"VW", "Golf 2", "11111111111111111", CarCategory.F, Availability.AVAILABLE));
        cas.deleteCar(0);

        ClientService cls = new ClientService(new ClientRepository());
        cls.create(new Client("Kacper",0));
        cls.updateClient(new Client(0, "KacperP", 0));
        cls.deleteClient(0);

    }
}