package com.hxf.mall.service.impl;


import com.hxf.mall.dao.CategoryMapper;
import com.hxf.mall.entity.Category;
import com.hxf.mall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> listAll() {
        return categoryMapper.listAll();
    }

    @Override
    public int total() {
        return categoryMapper.total();
    }

    @Override
    public Category add(Category category) {
        categoryMapper.add(category);
        return category;
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }
}
