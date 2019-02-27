package com.hxf.mall.service.impl;

import com.hxf.mall.dao.ProductImageMapper;
import com.hxf.mall.entity.ProductImage;
import com.hxf.mall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductImageServiceImpl implements ProductImageService{

    @Autowired
    private ProductImageMapper productImageMapper;

    @Override
    public List<ProductImage> listProductImage(Map params) {
        return productImageMapper.select_productimage_by_type(params);
    }
}
