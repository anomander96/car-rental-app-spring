package com.lab.app.dto;

import com.lab.app.validation.AdvanceValidationGroup;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.security.Timestamp;

@Data
@Builder
public class OrderDto {

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private Long orderId;

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private Long userId;

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private Long carId;

    @NotNull(message = "{id.notnull}", groups = AdvanceValidationGroup.class)
    private Long orderStatusId;

    private boolean withDriver;
    private Timestamp createDate;
    private int rentDuration;
    private BigDecimal totalPrice;
}
