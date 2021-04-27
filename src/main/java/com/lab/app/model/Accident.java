package com.lab.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.security.Timestamp;

@Entity
@Table(name = "accident")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accidentId;
    private Long accidentCategoryId;
    private Long orderId;
    private String description;
    private Timestamp accidentTime;
    private BigDecimal costPerDamage;
}
