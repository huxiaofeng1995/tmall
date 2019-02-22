package com.hxf.mall.dao;


import com.hxf.mall.entity.Category;

import java.util.List;

public interface CategoryMapper {
    public List<Category> listAll();
    public int total();
    public Category add(Category category);
}
