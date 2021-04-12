package com.lab.app.repository;

import com.lab.app.model.Car;

public interface CarRepository {

    Car getCar(int carId);

    Car createCar(Car car);

    Car updateCar(Car car, int carId);

    void deleteCar(int carId);
}
