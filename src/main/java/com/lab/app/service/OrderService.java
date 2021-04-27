package com.lab.app.service;

import com.lab.app.dto.OrderDto;

public interface OrderService {

    OrderDto getOrder(Long orderId);

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(OrderDto orderDto, Long orderId);

    void deleteOrder(Long orderId);
}
