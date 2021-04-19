package com.lab.app.repository.impl;

import com.lab.app.exception.CarNotFoundException;
import com.lab.app.model.Car;
import com.lab.app.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CarRepositoryImpl implements CarRepository {

    private final List<Car> carList = new ArrayList<>();

    @Override
    public Car getCar(int carId) {
        log.info("|| Repository layer: Getting car with id: {} ||", carId);
        return carList.stream()
                .filter(car -> car.getCarId() == carId)
                .findFirst()
                .orElseThrow(CarNotFoundException::new);
    }

    @Override
    public Car createCar(Car car) {
        carList.add(car);
        log.info("|| Repository layer: Creating a new car ||");
        return car;
    }

    @Override
    public Car updateCar(Car car, int carId) {
        boolean isDeleted = carList.removeIf(c -> c.getCarId() == carId);
        if (isDeleted) {
            carList.add(car);
        } else {
            throw new CarNotFoundException();
        }
        log.info("|| Repository layer: Updating car with id: {} ||", carId);
        return car;
    }

    @Override
    public void deleteCar(int carId) {
        log.info("|| Repository layer: Deleting car with id: {} ||", carId);
        carList.removeIf(car -> car.getCarId() == carId);
    }
}
