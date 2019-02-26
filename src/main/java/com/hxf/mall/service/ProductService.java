package com.hxf.mall.service;

import com.hxf.mall.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(Integer cid);

    void addProduct(Product product);

    void delProduct(Integer id);

    Product getProduct(Integer id);

    void updateProduct(Product product);
}
