package com.lab.app.model;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class Car {

    private int carId;
    private int carCategoryId;
//    private String vinNumber;
    private String brandName;
    private String modelName;
    private String color;
    private BigDecimal price;
}
