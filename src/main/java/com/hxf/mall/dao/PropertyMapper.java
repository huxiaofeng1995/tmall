package com.hxf.mall.dao;

import com.hxf.mall.entity.Property;

import java.util.List;

public interface PropertyMapper {
    List<Property> select_property_list(Integer cid);

    void insert_property(Property property);

    void delete_property(Integer id);

    Property select_property_by_id(Integer id);

    void update_property(Property property);
}
