package com.lab.app.repository.impl;

import com.lab.app.model.Accident;
import com.lab.app.repository.AccidentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Slf4j
public class AccidentRepositoryImpl implements AccidentRepository {

    private final List<Accident> accidentList = new ArrayList<>();

    @Override
    public Accident getAccident(int accidentId) {
        log.info("|| Repository layer: Getting accident with id: {} ||", accidentId);
        return accidentList.stream()
                .filter(accident -> accident.getAccidentId() == accidentId)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Accident createAccident(Accident accident) {
        log.info("|| Repository layer: Creating a new accident ||");
        accidentList.add(accident);
        return accident;
    }

    @Override
    public Accident updateAccident(Accident accident, int accidentId) {
        boolean isDeleted = accidentList.removeIf(a -> a.getAccidentId() == accidentId);
        if (isDeleted) {
            accidentList.add(accident);
        } else {
            throw new RuntimeException();
        }
        log.info("|| Repository layer: Updating accident with id: {} ||", accidentId);
        return accident;
    }

    @Override
    public void deleteAccident(int accidentId) {
        log.info("|| Repository layer: Deleting accident with id: {} ||", accidentId);
        accidentList.removeIf(accident -> accident.getAccidentId() == accidentId);
    }
}
