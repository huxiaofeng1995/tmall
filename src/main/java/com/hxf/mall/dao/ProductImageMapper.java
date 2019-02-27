package com.hxf.mall.dao;

import com.hxf.mall.entity.ProductImage;

import java.util.List;
import java.util.Map;

public interface ProductImageMapper {
    List<ProductImage> select_productimage_by_type(Map params);
}
