package com.lab.app.controller;

import com.lab.app.dto.OrderDto;
import com.lab.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{orderId}")
    public OrderDto getOrder(@PathVariable int orderId) {
        log.info("Extracting order with id: {}", orderId);
        return orderService.getOrder(orderId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        log.info("Order: {} successfully created", orderDto);
        return orderService.createOrder(orderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{orderId}")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto, @PathVariable int orderId) {
        log.info("Order: {} successfully updated", orderDto);
        return orderService.updateOrder(orderDto, orderId);
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
        log.info("Order with id: {} successfully deleted", orderId);
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
