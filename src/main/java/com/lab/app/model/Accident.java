package com.lab.app.model;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.security.Timestamp;

@Data
@Builder
public class Accident {

    private int accidentId;
    private int accidentCategoryId;
    private int orderId;
    private String description;
    private Timestamp accidentTime;
    private BigDecimal costPerDamage;
}
