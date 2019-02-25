package com.hxf.mall.dao;


import com.hxf.mall.entity.Category;

import java.util.List;

public interface CategoryMapper {
    public List<Category> listAll();
    public int total();
    public void add(Category category);

    void delete(Integer id);

    Category getCategoryById(Integer id);

    void update(Category category);
}
