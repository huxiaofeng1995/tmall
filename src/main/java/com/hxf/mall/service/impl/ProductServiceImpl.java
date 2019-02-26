package com.hxf.mall.service.impl;

import com.hxf.mall.dao.ProductMapper;
import com.hxf.mall.entity.Product;
import com.hxf.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProducts(Integer cid) {
        return productMapper.select_product_list(cid);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insert_product(product);
    }

    @Override
    public void delProduct(Integer id) {
        productMapper.delete_product(id);
    }

    @Override
    public Product getProduct(Integer id) {
        return productMapper.select_product_by_id(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.update_product(product);
    }
}
