package com.hxf.mall.service;

import com.hxf.mall.entity.Property;

import java.util.List;

public interface PropertyService {
    public List<Property> getProperties(Integer cid);

    void addProperty(Property property);

    void delProperty(Integer id);

    Property getProperty(Integer id);

    void updateProperty(Property property);
}
