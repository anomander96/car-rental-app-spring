package com.lab.app.service.impl;

import com.lab.app.dto.CarDto;
import com.lab.app.mapper.CarMapper;
import com.lab.app.model.Car;
import com.lab.app.repository.CarRepository;
import com.lab.app.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImpl implements CarService, CarMapper {

    private final CarRepository carRepository;

    @Override
    public CarDto getCar(int carId) {
        Car car = carRepository.getCar(carId);
        log.info("|| Service layer: Getting a car with id: {} ||", carId);
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.createCar(car);
        log.info("|| Service layer: Creating a new car ||");
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto updateCar(CarDto carDto, int carId) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.updateCar(car, carId);
        log.info("|| Service layer: Updating a car with id: {} ||", carId);
        return mapCarToCarDto(car);
    }

    @Override
    public void deleteCar(int carId) {
        log.info("|| Service layer: deleting a car with id: {} ||", carId);
        carRepository.deleteCar(carId);
    }

    @Override
    public Car mapCarDtoToCar(CarDto carDto) {
        return Car.builder()
                .carId(carDto.getCarId())
                .carCategoryId(carDto.getCarCategoryId())
                .brandName(carDto.getBrandName())
                .modelName(carDto.getModelName())
                .color(carDto.getColor())
                .price(carDto.getPrice())
                .build();

    }

    @Override
    public CarDto mapCarToCarDto(Car car) {
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
