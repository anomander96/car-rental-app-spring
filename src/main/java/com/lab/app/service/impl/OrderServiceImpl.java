package com.lab.app.service.impl;

import com.lab.app.dto.OrderDto;
import com.lab.app.mapper.OrderMapper;
import com.lab.app.model.Order;
import com.lab.app.repository.OrderRepository;
import com.lab.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService, OrderMapper {

    private OrderRepository orderRepository;

    @Override
    public OrderDto getOrder(int orderId) {
        Order order = orderRepository.getOrder(orderId);
        log.info("|| Service layer: Getting an order with id: {} ||", orderId);
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.createOrder(order);
        log.info("|| Service layer: Creating a new order ||");
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, int orderId) {
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.updateOrder(order, orderId);
        log.info("|| Service layer: Updating an order with id: {} ||", orderId);
        return mapOrderToOrderDto(order);
    }

    @Override
    public void deleteOrder(int orderId) {
        log.info("|| Service layer: Deleting an order with id: {} ||", orderId);
        orderRepository.deleteOrder(orderId);
    }

    @Override
    public Order mapOrderDtoToOrder(OrderDto orderDto) {
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

    @Override
    public OrderDto mapOrderToOrderDto(Order order) {
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
