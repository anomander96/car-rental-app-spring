package com.lab.app.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.security.Timestamp;

@Data
@Builder
public class Order {

    private int orderId;
    private int userId;
    private int carId;
    private int orderStatusId;
    private boolean withDriver;
    private Timestamp createDate;
    private int rentDuration;
    private BigDecimal totalPrice;
}
