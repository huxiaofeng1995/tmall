package com.hxf.mall.controller;

import com.hxf.mall.entity.ProductImage;
import com.hxf.mall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @GetMapping("products/{pid}/productImages")
    public List<ProductImage> listProductImages(String type, @PathVariable Integer pid){
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("pid", pid);
        return productImageService.listProductImage(map);
    }
}
