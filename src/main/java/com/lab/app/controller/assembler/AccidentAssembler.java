package com.lab.app.controller.assembler;

import com.lab.app.controller.AccidentController;
import com.lab.app.controller.model.AccidentModel;
import com.lab.app.dto.AccidentDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class AccidentAssembler extends RepresentationModelAssemblerSupport<AccidentDto, AccidentModel> {

    public AccidentAssembler() {
        super(AccidentController.class, AccidentModel.class);
    }

    @Override
    public AccidentModel toModel(AccidentDto entity) {
        AccidentModel accidentModel = new AccidentModel(entity);

        Link getAccident = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(AccidentController.class)
                .getAccident(entity.getAccidentId()))
                .withRel("getAccident");

        Link updateAccident = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(AccidentController.class)
                .updateAccident(entity, entity.getAccidentId()))
                .withRel("updateAccident");

        Link deleteAccident = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(AccidentController.class)
                .deleteAccident(entity.getAccidentId()))
                .withRel("deleteAccident");

        accidentModel.add(getAccident, updateAccident, deleteAccident);
        return accidentModel;

    }
}
