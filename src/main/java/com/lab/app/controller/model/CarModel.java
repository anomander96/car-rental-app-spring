package com.lab.app.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.lab.app.dto.CarDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class CarModel extends RepresentationModel<CarModel> {

    @JsonUnwrapped
    private CarDto carDto;
}
