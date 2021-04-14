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
        log.info("|| Repository layer: Getting order with id: {} ||", orderId);
        return orderList.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Order createOrder(Order order) {
        orderList.add(order);
        log.info("|| Repository layer: Creating a new order ||");
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
        log.info("|| Repository layer: Updating order with id: {} ||", orderId);
        return order;
    }

    @Override
    public void deleteOrder(int orderId) {
        log.info("|| Repository layer: Deleting order with id: {} ||", orderId);
        orderList.removeIf(order -> order.getOrderId() == orderId);
    }

}
