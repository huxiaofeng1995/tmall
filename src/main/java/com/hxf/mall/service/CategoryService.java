package com.hxf.mall.service;



import com.hxf.mall.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> listAll();
    public int total();
    public Category add(Category category);

    void delete(Integer id);
}
