package com.lab.app.repository.impl;

import com.lab.app.model.Order;
import com.lab.app.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Slf4j
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> orderList = new ArrayList<>();

    @Override
    public Order getOrder(int orderId) {
        log.info("Getting order with id: {} from database", orderId);
        return orderList.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Order createOrder(Order order) {
        orderList.add(order);
        log.info("Creating a new order in database");
        return order;
    }

    @Override
    public Order updateOrder(Order order, int orderId) {
        boolean isDeleted = orderList.removeIf(o -> o.getOrderId() == orderId);
        if (isDeleted) {
            orderList.add(order);
        } else {
            throw new RuntimeException();
        }
        log.info("Updating order in database");
        return order;
    }

    @Override
    public void deleteOrder(int orderId) {
        log.info("Deleting order with id: {} in database", orderId);
        orderList.removeIf(order -> order.getOrderId() == orderId);
    }

}
