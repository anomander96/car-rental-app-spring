package com.lab.app.service.impl;

import com.lab.app.dto.AccidentDto;
import com.lab.app.model.Accident;
import com.lab.app.repository.AccidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccidentServiceImpl {

    private final AccidentRepository accidentRepository;

    public AccidentDto getAccident(int accidentId) {
        Accident accident = accidentRepository.getAccident(accidentId);
        return mapAccidentToAccidentDto(accident);
    }

    public AccidentDto createAccident(AccidentDto accidentDto) {
        Accident accident = mapAccidentDtoToAccident(accidentDto);
        accident = accidentRepository.createAccident(accident);
        return mapAccidentToAccidentDto(accident);
    }

    public AccidentDto updateAccident(AccidentDto accidentDto, int accidentId) {
        Accident accident = mapAccidentDtoToAccident(accidentDto);
        accident = accidentRepository.updateAccident(accident, accidentId);
        return mapAccidentToAccidentDto(accident);
    }

    public void deleteAccident(int accidentId) {
        accidentRepository.deleteAccident(accidentId);
    }

    private Accident mapAccidentDtoToAccident(AccidentDto accidentDto) {
        return Accident.builder()
                .accidentId(accidentDto.getAccidentId())
                .accidentCategoryId(accidentDto.getAccidentCategoryId())
                .orderId(accidentDto.getOrderId())
                .description(accidentDto.getDescription())
                .accidentTime(accidentDto.getAccidentTime())
                .costPerDamage(accidentDto.getCostPerDamage())
                .build();
    }

    private AccidentDto mapAccidentToAccidentDto(Accident accident) {
        return AccidentDto.builder()
                .accidentId(accident.getAccidentId())
                .accidentCategoryId(accident.getAccidentCategoryId())
                .orderId(accident.getOrderId())
                .description(accident.getDescription())
                .accidentTime(accident.getAccidentTime())
                .costPerDamage(accident.getCostPerDamage())
                .build();
    }
}
