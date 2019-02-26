package com.hxf.mall.dao;

import com.hxf.mall.entity.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> select_product_list(Integer cid);

    void insert_product(Product product);

    void delete_product(Integer id);

    Product select_product_by_id(Integer id);

    void update_product(Product product);
}
