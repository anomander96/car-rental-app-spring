package com.lab.app.api;

import com.lab.app.controller.model.CarModel;
import com.lab.app.dto.CarDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Car management API")
@RequestMapping(value = "/api/v1/cars")
public interface CarApi {

    @ApiOperation("Getting car from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{carId}")
    CarModel getCar(@PathVariable Long carId);

    @ApiOperation("Creating car")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CarModel createCar(@Valid @RequestBody CarDto carDto);

    @ApiOperation("Updating car")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{carId}")
    CarModel updateCar(@Valid @RequestBody CarDto carDto, @PathVariable Long carId);

    @ApiOperation("Deleting car")
    @DeleteMapping(value = "/{carId}")
    ResponseEntity<Void> deleteCar(@PathVariable Long carId);
}
