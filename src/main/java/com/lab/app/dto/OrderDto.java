package com.lab.app.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.security.Timestamp;

@Data
@Builder
public class OrderDto {

    private int orderId;
    private int userId;
    private int carId;
    private int orderStatusId;
    private boolean withDriver;
    private Timestamp createDate;
    private int rentDuration;
    private BigDecimal totalPrice;
}
