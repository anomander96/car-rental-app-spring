package com.lab.app.mapper;

import com.lab.app.dto.OrderDto;
import com.lab.app.model.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    Order mapOrderDtoToOrder(OrderDto orderDto);

    OrderDto mapOrderToOrderDto(Order order);
}
