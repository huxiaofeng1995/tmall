package com.hxf.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxf.mall.entity.Product;
import com.hxf.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "categories/{cid}/products")
    public PageInfo getProducts(@PathVariable Integer cid, @RequestParam(value = "start",defaultValue = "1")int start, @RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(start, size);
        PageInfo<Product> page = new PageInfo<>(productService.getProducts(cid));
        return page;
    }

    @PostMapping("products")
    public String addProduct(@RequestBody Product product){//前端传参格式为json，则这里要用RequstBody来接收
        productService.addProduct(product);
        return "success";
    }

    @DeleteMapping("products/{id}")
    public String delProduct(@PathVariable Integer id){
        productService.delProduct(id);
        return null;
    }

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    @PutMapping("products")
    public String updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return "success";
    }
}
