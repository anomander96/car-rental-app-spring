package com.lab.app.service.impl;

import com.lab.app.dto.AccidentDto;
import com.lab.app.exception.AccidentNotFoundException;
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
    public AccidentDto getAccident(Long accidentId) {
        Accident accident = accidentRepository.findByAccidentId(accidentId)
                .orElseThrow(AccidentNotFoundException::new);
        log.info("|| Service layer: Getting an accident with id: {} ||", accidentId);
        return mapAccidentToAccidentDto(accident);
    }

    @Override
    public AccidentDto createAccident(AccidentDto accidentDto) {
        Accident accident = mapAccidentDtoToAccident(accidentDto);
        accident = accidentRepository.save(accident);
        log.info("|| Service layer: Creating a new accident ||");
        return mapAccidentToAccidentDto(accident);
    }

    @Override
    public AccidentDto updateAccident(AccidentDto accidentDto, Long accidentId) {
        Accident accident = mapAccidentDtoToAccident(accidentDto);
        if (accidentRepository.findByAccidentId(accidentId).isPresent()) {
            accident = accidentRepository.save(accident);
        } else {
            throw new AccidentNotFoundException();
        }
        log.info("|| Service layer: Updating accident with id: {} ||", accidentId);
        return mapAccidentToAccidentDto(accident);
    }

    @Override
    public void deleteAccident(Long accidentId) {
        log.info("|| Service layer: Deleting accident with id: {} ||", accidentId);
        Accident accident = accidentRepository.findByAccidentId(accidentId)
                .orElseThrow(AccidentNotFoundException::new);
        accidentRepository.delete(accident);
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
