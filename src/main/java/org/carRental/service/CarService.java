package org.carRental.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.carRental.execption.CarNotFoundException;
import org.carRental.execption.ValidationException;
import org.carRental.model.Car;
import org.carRental.model.types.Availability;
import org.carRental.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CarService {
    @NonNull private final CarRepository carRepository;

    public Car create(Car car) {
        if(car.getBrand().isEmpty())
            throw new ValidationException("Brand", "cannot be blank");
        if(car.getModel().isEmpty())
            throw new ValidationException("Model", "cannot be blank");
        if(car.getVin().isEmpty())
            throw new ValidationException("Vin", "cannot be blank");
        if(car.getVin().length() != 17)
            throw new ValidationException("Vin", "lenth must be 17");

        return carRepository.create(car);
    }

    public void deleteCar(Integer carId) {
        if (carId == null)
            throw new ValidationException("id", "cannot be null");
        carRepository.removeById(carId);
    }

    public List<Car> getAvailableCars(){
        return carRepository.getByStatus(Availability.AVAILABLE);
    }

    public List<Car> getAll() {
        return  carRepository.getCarList();
    }

    public Car getCar(Integer carId) {
        if (carId == null)
            throw new ValidationException("id", "cannot be null");

        return carRepository.getById(carId).orElseThrow(() -> new CarNotFoundException("Car with the given id does not exist"));
    }

    public void updateCar(Car updatedCar) {
        if (updatedCar.getId() == null)
            throw new ValidationException("id", "cannot be null");
        carRepository.modifyCar(updatedCar).orElseThrow(() -> new CarNotFoundException("Car with the given id does not exist"));
    }

}
