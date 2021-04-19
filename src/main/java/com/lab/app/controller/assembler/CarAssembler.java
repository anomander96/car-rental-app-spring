package com.lab.app.controller.assembler;

import com.lab.app.controller.CarController;
import com.lab.app.controller.model.CarModel;
import com.lab.app.dto.CarDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CarAssembler extends RepresentationModelAssemblerSupport<CarDto, CarModel> {

    public CarAssembler() {
        super(CarController.class, CarModel.class);
    }

    @Override
    public CarModel toModel(CarDto entity) {
        CarModel carModel = new CarModel(entity);

        Link getCar = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(CarController.class)
                .getCar(entity.getCarId()))
                .withRel("getCar");

        Link updateCar = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(CarController.class)
                .updateCar(entity, entity.getCarId()))
                .withRel("updateCar");

        Link deleteCar = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(CarController.class)
                .deleteCar(entity.getCarId()))
                .withRel("deleteCar");

        carModel.add(getCar, updateCar, deleteCar);
        return carModel;
    }
}
