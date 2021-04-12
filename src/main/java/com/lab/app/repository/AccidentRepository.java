package com.lab.app.repository;

import com.lab.app.model.Accident;

public interface AccidentRepository {
    Accident getAccident(int accidentId);

    Accident createAccident(Accident accident);

    Accident updateAccident(Accident accident, int accidentId);

    void deleteAccident(int accidentId);
}
