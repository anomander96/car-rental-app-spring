package com.lab.app.service;

import com.lab.app.dto.AccidentDto;

public interface AccidentService {

    AccidentDto getAccident(Long accidentId);

    AccidentDto createAccident(AccidentDto accidentDto);

    AccidentDto updateAccident(AccidentDto accidentDto, Long accidentId);

    void deleteAccident(Long accidentId);
}
