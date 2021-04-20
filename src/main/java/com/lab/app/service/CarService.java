package com.lab.app.service;

import com.lab.app.dto.CarDto;

public interface CarService {

    CarDto getCar(Long carId);

    CarDto createCar(CarDto carDto);

    CarDto updateCar(CarDto carDto, Long carId);

    void deleteCar(Long carId);
}
