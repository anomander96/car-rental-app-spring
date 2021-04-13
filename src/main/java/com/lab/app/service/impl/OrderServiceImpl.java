package com.lab.app.service.impl;

import com.lab.app.dto.OrderDto;
import com.lab.app.model.Order;
import com.lab.app.repository.OrderRepository;
import com.lab.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public OrderDto getOrder(int orderId) {
        Order order = orderRepository.getOrder(orderId);
        log.info("Order with id: {} founded", orderId);
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.createOrder(order);
        log.info("Order: {} added", orderDto);
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, int orderId) {
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.updateOrder(order, orderId);
        log.info("Order with id: {} updated", orderId);
        return mapOrderToOrderDto(order);
    }

    @Override
    public void deleteOrder(int orderId) {
        log.info("Order with id: {} deleted", orderId);
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
