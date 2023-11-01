package org.carRental.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.carRental.model.Car;
import org.carRental.model.types.Availability;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CarRepository {

    private static Logger logger = LogManager.getLogger(CarRepository.class);
    @Getter
    private List<Car> carList = new ArrayList<>();
    public Car create(Car car) {
        car.setId(carList.size());
        carList.add(car);
        logger.info("Added Car: " + car + " to car List");
        return car;
    }

    public Optional<Car> getById(Integer id){
        return carList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    public List<Car> getByStatus(Availability carStatus){
        return carList
                .stream()
                .filter(it -> it.getAvailability().equals(carStatus))
                .collect(Collectors.toList());
    }

    public void removeById(Integer id) {
        Optional<Car> car = getById(id);
        car.ifPresent(it -> {
            carList.remove(it);
            logger.info("Removed Car: " + car + " from car List");
        });
    }

    public void removeAll(){
        carList = new ArrayList<>();
    }

    public Optional<Car> modifyCar(Car car) {
        Optional<Car> carToModify = getById(car.getId());

        return carToModify.map(it -> {
            logger.info("Modified Car: " +it+ " to: " + car);
            it.setBrand(car.getBrand());
            it.setCarClass(car.getCarClass());
            it.setVin(car.getVin());
            it.setAvailability(car.getAvailability());
            it.setModel(it.getModel());

            return it;
        });
    }
}
