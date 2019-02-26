package com.hxf.mall.service.impl;

import com.hxf.mall.dao.PropertyMapper;
import com.hxf.mall.entity.Property;
import com.hxf.mall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public List<Property> getProperties(Integer cid) {
        return propertyMapper.select_property_list(cid);
    }

    @Override
    public void addProperty(Property property) {
        propertyMapper.insert_property(property);
    }

    @Override
    public void delProperty(Integer id) {
        propertyMapper.delete_property(id);
    }
}
