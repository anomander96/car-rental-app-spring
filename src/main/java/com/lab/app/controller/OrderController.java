package com.lab.app.controller;

import com.lab.app.controller.assembler.OrderAssembler;
import com.lab.app.controller.model.OrderModel;
import com.lab.app.dto.OrderDto;
import com.lab.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController implements com.lab.app.api.OrderApi {

    private final OrderService orderService;
    private final OrderAssembler orderAssembler;

    @Override
    public OrderModel getOrder(int orderId) {
        log.info("|| Controller layer: Extracting order with id: {} ||", orderId);
        OrderDto order = orderService.getOrder(orderId);
        return orderAssembler.toModel(order);
    }

    @Override
    public OrderModel createOrder(OrderDto orderDto) {
        log.info("|| Controller layer: Order: {} successfully created ||", orderDto);
        OrderDto order = orderService.createOrder(orderDto);
        return orderAssembler.toModel(order);
    }

    @Override
    public OrderModel updateOrder(OrderDto orderDto, int orderId) {
        log.info("|| Controller layer: Order: {} successfully updated ||", orderDto);
        OrderDto order = orderService.updateOrder(orderDto, orderId);
        return orderAssembler.toModel(order);
    }

    @Override
    public ResponseEntity<Void> deleteOrder(int orderId) {
        log.info("|| Controller layer: Order with id: {} successfully deleted ||", orderId);
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
