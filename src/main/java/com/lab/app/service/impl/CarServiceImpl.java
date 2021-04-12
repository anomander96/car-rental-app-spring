package com.lab.app.service.impl;

import com.lab.app.dto.CarDto;
import com.lab.app.model.Car;
import com.lab.app.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl {

    private final CarRepository carRepository;

    public CarDto getCar(int carId) {
        Car car = carRepository.getCar(carId);
        return mapCarToCarDto(car);
    }

    public CarDto createCar(CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.createCar(car);
        return mapCarToCarDto(car);
    }

    public CarDto updateCar(CarDto carDto, int carId) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.updateCar(car, carId);
        return mapCarToCarDto(car);
    }

    public void deleteCar(int carId) {
        carRepository.deleteCar(carId);
    }

    private Car mapCarDtoToCar(CarDto carDto) {
        return Car.builder()
                .carId(carDto.getCarId())
                .carCategoryId(carDto.getCarCategoryId())
                .brandName(carDto.getBrandName())
                .modelName(carDto.getModelName())
                .color(carDto.getColor())
                .price(carDto.getPrice())
                .build();

    }

    private CarDto mapCarToCarDto(Car car) {
        return CarDto.builder()
                .carId(car.getCarId())
                .carCategoryId(car.getCarCategoryId())
                .brandName(car.getBrandName())
                .modelName(car.getModelName())
                .color(car.getColor())
                .price(car.getPrice())
                .build();

    }
}
