package com.lab.app.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.security.Timestamp;

@Data
@Builder
public class AccidentDto {

    private int accidentId;
    private int accidentCategoryId;
    private int orderId;
    private String description;
    private Timestamp accidentTime;
    private BigDecimal costPerDamage;
}
