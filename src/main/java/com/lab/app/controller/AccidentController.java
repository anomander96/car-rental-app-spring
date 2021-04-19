package com.lab.app.controller;

import com.lab.app.api.AccidentApi;
import com.lab.app.controller.assembler.AccidentAssembler;
import com.lab.app.controller.model.AccidentModel;
import com.lab.app.dto.AccidentDto;
import com.lab.app.service.AccidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AccidentController implements AccidentApi {

    private final AccidentService accidentService;
    private final AccidentAssembler accidentAssembler;

    @Override
    public AccidentModel getAccident(int accidentId) {
        log.info("|| Controller layer: Extracting accident with id: {} ||", accidentId);
        AccidentDto accident = accidentService.getAccident(accidentId);
        return accidentAssembler.toModel(accident);
    }

    @Override
    public AccidentModel createAccident(AccidentDto accidentDto) {
        log.info("|| Controller layer: Accident: {} successfully created ||", accidentDto);
        AccidentDto accident = accidentService.createAccident(accidentDto);
        return accidentAssembler.toModel(accident);
    }

    @Override
    public AccidentModel updateAccident(AccidentDto accidentDto, int accidentId) {
        log.info("|| Controller layer: Accident: {} successfully updated ||", accidentDto);
        AccidentDto accident = accidentService.updateAccident(accidentDto, accidentId);
        return accidentAssembler.toModel(accident);
    }

    @Override
    public ResponseEntity<Void> deleteAccident(int accidentId) {
        log.info("|| Controller layer: Accident with id: {} successfully deleted ||", accidentId);
        accidentService.deleteAccident(accidentId);
        return ResponseEntity.noContent().build();
    }

}
