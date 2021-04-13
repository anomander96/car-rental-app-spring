package com.lab.app.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CarDto {

    private int carId;
    private int carCategoryId;
//    private String vinNumber;
    private String brandName;
    private String modelName;
    private String color;
    private BigDecimal price;
}
