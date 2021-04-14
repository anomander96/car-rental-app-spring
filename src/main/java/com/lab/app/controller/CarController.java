package com.lab.app.controller;

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
@RequestMapping(value = "/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{carId}")
    public CarDto getCar(@PathVariable int carId) {
        log.info("|| Controller layer: Extracting car with id: {} ||", carId);
        return carService.getCar(carId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CarDto createCar(@Valid @RequestBody CarDto carDto) {
        log.info("|| Controller layer: Car: {} successfully created ||", carDto);
        return carService.createCar(carDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{carId}")
    public CarDto updateCar(@Valid @RequestBody CarDto carDto, @PathVariable int carId) {
        log.info("|| Controller layer: Car: {} successfully updated ||", carDto);
        return carService.updateCar(carDto, carId);
    }

    @DeleteMapping(value = "/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable int carId) {
        carService.deleteCar(carId);
        log.info("|| Controller layer: Car with id: {} successfully deleted ||", carId);
        return ResponseEntity.noContent().build();
    }
}
