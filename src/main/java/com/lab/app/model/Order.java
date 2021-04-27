package com.lab.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.security.Timestamp;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Long userId;
    private Long carId;
    private Long orderStatusId;
    private boolean withDriver;
    private Timestamp createDate;
    private int rentDuration;
    private BigDecimal totalPrice;
}
