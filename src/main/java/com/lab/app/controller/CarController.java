package com.lab.app.controller;

import com.lab.app.controller.assembler.CarAssembler;
import com.lab.app.controller.model.CarModel;
import com.lab.app.dto.CarDto;
import com.lab.app.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/cars")
@RequiredArgsConstructor
public class CarController implements com.lab.app.api.CarApi {

    private final CarService carService;
    private final CarAssembler carAssembler;

    @Override
    public CarModel getCar(int carId) {
        log.info("|| Controller layer: Extracting car with id: {} ||", carId);
        CarDto car = carService.getCar(carId);
        return carAssembler.toModel(car);
    }

    @Override
    public CarModel createCar(CarDto carDto) {
        log.info("|| Controller layer: Car: {} successfully created ||", carDto);
        CarDto car = carService.createCar(carDto);
        return carAssembler.toModel(car);
    }

    @Override
    public CarModel updateCar(CarDto carDto, int carId) {
        log.info("|| Controller layer: Car: {} successfully updated ||", carDto);
        CarDto car = carService.updateCar(carDto, carId);
        return carAssembler.toModel(car);
    }

    @Override
    public ResponseEntity<Void> deleteCar(int carId) {
        carService.deleteCar(carId);
        log.info("|| Controller layer: Car with id: {} successfully deleted ||", carId);
        return ResponseEntity.noContent().build();
    }
}
