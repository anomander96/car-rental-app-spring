package com.lab.app.service.impl;

import com.lab.app.dto.CarDto;
import com.lab.app.model.Car;
import com.lab.app.repository.CarRepository;
import com.lab.app.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public CarDto getCar(int carId) {
        Car car = carRepository.getCar(carId);
        log.info("Car with id: {} founded", carId);
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.createCar(car);
        log.info("Car: {} added", carDto);
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto updateCar(CarDto carDto, int carId) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.updateCar(car, carId);
        log.info("Car with id: {} updated", carId);
        return mapCarToCarDto(car);
    }

    @Override
    public void deleteCar(int carId) {
        log.info("Car with id: {} deleted", carId);
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
