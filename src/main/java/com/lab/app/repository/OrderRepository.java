package com.lab.app.repository;

import com.lab.app.model.Order;

public interface OrderRepository {
    Order getOrder(int orderId);

    Order createOrder(Order order);

    Order updateOrder(Order order, int orderId);

    void deleteOrder(int orderId);
}
