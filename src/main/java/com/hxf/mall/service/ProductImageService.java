package com.hxf.mall.service;

import com.hxf.mall.entity.ProductImage;

import java.util.List;
import java.util.Map;

public interface ProductImageService {
    List<ProductImage> listProductImage(Map params);

    void addProductImage(ProductImage bean);

    void delProductImage(Integer id);

    ProductImage getProductImage(Integer id);
}
