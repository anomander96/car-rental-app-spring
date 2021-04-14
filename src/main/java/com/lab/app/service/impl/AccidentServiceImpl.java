package com.lab.app.service.impl;

import com.lab.app.dto.AccidentDto;
import com.lab.app.mapper.AccidentMapper;
import com.lab.app.model.Accident;
import com.lab.app.repository.AccidentRepository;
import com.lab.app.service.AccidentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccidentServiceImpl implements AccidentService, AccidentMapper {

    private final AccidentRepository accidentRepository;

    @Override
    public AccidentDto getAccident(int accidentId) {
        Accident accident = accidentRepository.getAccident(accidentId);
        log.info("|| Service layer: Getting an accident with id: {} ||", accidentId);
        return mapAccidentToAccidentDto(accident);
    }

    @Override
    public AccidentDto createAccident(AccidentDto accidentDto) {
        Accident accident = mapAccidentDtoToAccident(accidentDto);
        accident = accidentRepository.createAccident(accident);
        log.info("|| Service layer: Creating a new accident ||");
        return mapAccidentToAccidentDto(accident);
    }

    @Override
    public AccidentDto updateAccident(AccidentDto accidentDto, int accidentId) {
        Accident accident = mapAccidentDtoToAccident(accidentDto);
        accident = accidentRepository.updateAccident(accident, accidentId);
        log.info("|| Service layer: Updating accident with id: {} ||", accidentId);
        return mapAccidentToAccidentDto(accident);
    }

    @Override
    public void deleteAccident(int accidentId) {
        log.info("|| Service layer: Deleting accident with id: {} ||", accidentId);
        accidentRepository.deleteAccident(accidentId);
    }

    @Override
    public Accident mapAccidentDtoToAccident(AccidentDto accidentDto) {
        return Accident.builder()
                .accidentId(accidentDto.getAccidentId())
                .accidentCategoryId(accidentDto.getAccidentCategoryId())
                .orderId(accidentDto.getOrderId())
                .description(accidentDto.getDescription())
                .accidentTime(accidentDto.getAccidentTime())
                .costPerDamage(accidentDto.getCostPerDamage())
                .build();
    }

    @Override
    public AccidentDto mapAccidentToAccidentDto(Accident accident) {
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
