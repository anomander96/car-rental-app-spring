package com.lab.app.controller;

import com.lab.app.dto.AccidentDto;
import com.lab.app.service.AccidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/accidents")
@RequiredArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{accidentId}")
    public AccidentDto getAccident(@PathVariable int accidentId) {
        log.info("Extracting accident with id: {}", accidentId);
        return accidentService.getAccident(accidentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AccidentDto createAccident(@RequestBody AccidentDto accidentDto) {
        log.info("Accident: {} successfully created", accidentDto);
        return accidentService.createAccident(accidentDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{accidentId}")
    public AccidentDto updateAccident(@RequestBody AccidentDto accidentDto, @PathVariable int accidentId) {
        log.info("Accident: {} successfully updated", accidentDto);
        return accidentService.updateAccident(accidentDto, accidentId);
    }

    @DeleteMapping(value = "/{accidentId}")
    public ResponseEntity<Void> deleteAccident(@PathVariable int accidentId) {
        log.info("Accident with id: {} successfully deleted", accidentId);
        accidentService.deleteAccident(accidentId);
        return ResponseEntity.noContent().build();
    }

}
