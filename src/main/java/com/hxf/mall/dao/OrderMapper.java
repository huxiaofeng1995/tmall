package com.hxf.mall.dao;

import com.hxf.mall.entity.Order;

import java.util.List;

public interface OrderMapper {
    public List<Order> select_order_list();

    void update_order(Order o);
}
