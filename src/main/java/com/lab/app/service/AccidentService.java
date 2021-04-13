package com.lab.app.service;

import com.lab.app.dto.AccidentDto;

public interface AccidentService {

    AccidentDto getAccident(int accidentId);

    AccidentDto createAccident(AccidentDto accidentDto);

    AccidentDto updateAccident(AccidentDto accidentDto, int accidentId);

    void deleteAccident(int accidentId);
}
