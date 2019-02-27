package com.hxf.mall.service.impl;

import com.hxf.mall.dao.PropertyValueMapper;
import com.hxf.mall.entity.PropertyValue;
import com.hxf.mall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {

    @Autowired
    private PropertyValueMapper propertyValueMapper;

    @Override
    public List<PropertyValue> getPropertyValues(Integer pid) {
        return propertyValueMapper.select_propertyvalue_list_by_pid(pid);
    }

    @Override
    public void updatePropertyValue(PropertyValue propertyValue) {
        propertyValueMapper.update_propertyvalue(propertyValue);
    }
}
