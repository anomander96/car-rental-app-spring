package com.lab.app.repository.impl;

import com.lab.app.model.Car;
import com.lab.app.repository.CarRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CarRepositoryImpl implements CarRepository {

    private final List<Car> carList = new ArrayList<>();

    @Override
    public Car getCar(int carId) {
        return carList.stream()
                .filter(car -> car.getCarId() == carId)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Car createCar(Car car) {
        carList.add(car);
        return car;
    }

    @Override
    public Car updateCar(Car car, int carId) {
        boolean isDeleted = carList.removeIf(c -> c.getCarId() == carId);
        if (isDeleted) {
            carList.add(car);
        } else {
            throw new NoSuchElementException();
        } return car;
    }

    @Override
    public void deleteCar(int carId) {
        carList.removeIf(car -> car.getCarId() == carId);
    }
}