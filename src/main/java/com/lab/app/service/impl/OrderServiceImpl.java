package com.lab.app.service.impl;

import com.lab.app.dto.OrderDto;
import com.lab.app.model.Order;
import com.lab.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private OrderRepository orderRepository;

    public OrderDto getOrder(int orderId) {
        Order order = orderRepository.getOrder(orderId);
        return mapOrderToOrderDto(order);
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.createOrder(order);
        return mapOrderToOrderDto(order);
    }

    public OrderDto updateOrder(OrderDto orderDto, int orderId) {
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.updateOrder(order, orderId);
        return mapOrderToOrderDto(order);
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteOrder(orderId);
    }

    private Order mapOrderDtoToOrder(OrderDto orderDto) {
        return Order.builder()
                .orderId(orderDto.getOrderId())
                .userId(orderDto.getUserId())
                .carId(orderDto.getCarId())
                .orderStatusId(orderDto.getOrderStatusId())
                .withDriver(orderDto.isWithDriver())
                .createDate(orderDto.getCreateDate())
                .rentDuration(orderDto.getRentDuration())
                .totalPrice(orderDto.getTotalPrice())
                .build();
    }

    private OrderDto mapOrderToOrderDto(Order order) {
        return OrderDto.builder()
                .orderId(order.getOrderId())
                .userId(order.getUserId())
                .carId(order.getCarId())
                .orderStatusId(order.getOrderStatusId())
                .withDriver(order.isWithDriver())
                .createDate(order.getCreateDate())
                .rentDuration(order.getRentDuration())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}
