package com.lab.app.dto;

import com.lab.app.validation.AdvanceValidationGroup;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.security.Timestamp;

@Data
@Builder
public class AccidentDto {

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private int accidentId;

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private int accidentCategoryId;

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private int orderId;

    private String description;
    private Timestamp accidentTime;
    private BigDecimal costPerDamage;
}
