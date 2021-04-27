package com.lab.app.api;

import com.lab.app.controller.model.AccidentModel;
import com.lab.app.dto.AccidentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Accident management API")
@RequestMapping(value = "/api/v1/accidents")
public interface AccidentApi {

    @ApiOperation("Getting accident from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{accidentId}")
    AccidentModel getAccident(@PathVariable Long accidentId);

    @ApiOperation("Creating accident")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AccidentModel createAccident(@Valid @RequestBody AccidentDto accidentDto);

    @ApiOperation("Updating accident")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{accidentId}")
    AccidentModel updateAccident(@Valid @RequestBody AccidentDto accidentDto, @PathVariable Long accidentId);

    @ApiOperation("Deleting accident")
    @DeleteMapping(value = "/{accidentId}")
    ResponseEntity<Void> deleteAccident(@PathVariable Long accidentId);
}
