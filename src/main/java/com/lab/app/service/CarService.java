package com.lab.app.service;

import com.lab.app.dto.CarDto;

public interface CarService {

    CarDto getCar(int carId);

    CarDto createCar(CarDto carDto);

    CarDto updateCar(CarDto carDto, int carId);

    void deleteCar(int carId);
}
