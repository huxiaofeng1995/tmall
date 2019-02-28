package com.hxf.mall.service;


import com.hxf.mall.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getOrders();

    void updateOrder(Order o);
}
