package com.lab.app.dto;

import com.lab.app.validation.AdvanceValidationGroup;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class CarDto {

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private int carId;

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private int carCategoryId;

    private String brandName;
    private String modelName;
    private String color;
    private BigDecimal price;
}
