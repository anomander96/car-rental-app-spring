package com.lab.app.service;

import com.lab.app.dto.OrderDto;

public interface OrderService {

    OrderDto getOrder(int orderId);

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(OrderDto orderDto, int orderId);

    void deleteOrder(int orderId);
}
