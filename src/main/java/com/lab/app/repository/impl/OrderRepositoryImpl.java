package com.lab.app.repository.impl;

import com.lab.app.model.Order;
import com.lab.app.repository.OrderRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> orderList = new ArrayList<>();

    @Override
    public Order getOrder(int orderId) {
        return orderList.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Order createOrder(Order order) {
        orderList.add(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order, int orderId) {
        boolean isDeleted = orderList.removeIf(o -> o.getOrderId() == orderId);
        if (isDeleted) {
            orderList.add(order);
        } else {
            throw new RuntimeException();
        } return order;
    }

    @Override
    public void deleteOrder(int orderId) {
        orderList.removeIf(order -> order.getOrderId() == orderId);
    }

}
