package com.hxf.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxf.mall.entity.*;
import com.hxf.mall.service.OrderService;
import com.hxf.mall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductImageService productImageService;

    @GetMapping("orders")
    public PageInfo<Order> getUsers(@RequestParam(value = "start",defaultValue = "1")int start, @RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(start, size);
        List<Order> orders = orderService.getOrders();
        //设置每个订单的总金额和总物品数
        for(Order o : orders){
            float total = 0.0f;
            int totalNumber = 0;
            List<OrderItem> oitems = o.getOrderItems();
            for(OrderItem i : oitems){
                //设置每个产品的第一张图片
                Product p = i.getProduct();
                Map<String, Object> map = new HashMap<>();
                map.put("type", "Single");
                map.put("pid", p.getId());
                List<ProductImage> images = productImageService.listProductImage(map);
                p.setFirstProductImage(images.get(0));
                totalNumber += i.getNumber();
                total += p.getPromotePrice()*i.getNumber();
            }
            o.setTotal(total);
            o.setTotalNumber(totalNumber);
        }
        PageInfo<Order> page = new PageInfo<>(orders);
        return page;
    }

    @PutMapping("deliveryOrder/{id}")
    public String deliveryOrder(@PathVariable Integer id){
        Order o = new Order();
        o.setId(id);
        o.setStatus("waitConfirm");
        o.setDeliveryDate(new Date());
        orderService.updateOrder(o);
        return "success";
    }
}
