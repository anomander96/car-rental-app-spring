package com.lab.app.repository.impl;

import com.lab.app.model.Car;
import com.lab.app.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Slf4j
public class CarRepositoryImpl implements CarRepository {

    private final List<Car> carList = new ArrayList<>();

    @Override
    public Car getCar(int carId) {
        log.info("Getting car with id: {} from database", carId);
        return carList.stream()
                .filter(car -> car.getCarId() == carId)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Car createCar(Car car) {
        carList.add(car);
        log.info("Creating a new car in database");
        return car;
    }

    @Override
    public Car updateCar(Car car, int carId) {
        boolean isDeleted = carList.removeIf(c -> c.getCarId() == carId);
        if (isDeleted) {
            carList.add(car);
        } else {
            throw new NoSuchElementException();
        }
        log.info("Updating car in database");
        return car;
    }

    @Override
    public void deleteCar(int carId) {
        log.info("Deleting car with id: {} from database", carId);
        carList.removeIf(car -> car.getCarId() == carId);
    }
}
