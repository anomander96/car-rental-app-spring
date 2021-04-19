package com.lab.app.controller.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.lab.app.dto.AccidentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class AccidentModel extends RepresentationModel<AccidentModel> {

    @JsonUnwrapped
    private AccidentDto accidentDto;
}
