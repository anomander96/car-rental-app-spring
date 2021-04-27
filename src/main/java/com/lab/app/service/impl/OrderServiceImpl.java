package com.lab.app.service.impl;

import com.lab.app.dto.OrderDto;
import com.lab.app.exception.OrderNotFoundException;
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
    public OrderDto getOrder(Long orderId) {
        Order order = orderRepository.findByOrderId(orderId)
                .orElseThrow(OrderNotFoundException::new);
        log.info("|| Service layer: Getting an order with id: {} ||", orderId);
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.save(order);
        log.info("|| Service layer: Creating a new order ||");
        return mapOrderToOrderDto(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, Long orderId) {
        Order order = mapOrderDtoToOrder(orderDto);
        if (orderRepository.findByOrderId(orderId).isPresent()) {
            order = orderRepository.save(order);
        } else {
            throw new OrderNotFoundException();
        }
        log.info("|| Service layer: Updating an order with id: {} ||", orderId);
        return mapOrderToOrderDto(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        log.info("|| Service layer: Deleting an order with id: {} ||", orderId);
        Order order = orderRepository.findByOrderId(orderId)
                .orElseThrow(OrderNotFoundException::new);
        orderRepository.delete(order);
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
