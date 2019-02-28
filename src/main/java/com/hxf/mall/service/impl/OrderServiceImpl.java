package com.hxf.mall.service.impl;

import com.hxf.mall.dao.OrderMapper;
import com.hxf.mall.entity.Order;
import com.hxf.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrders() {
        return orderMapper.select_order_list();
    }

    @Override
    public void updateOrder(Order o) {
        orderMapper.update_order(o);
    }
}
