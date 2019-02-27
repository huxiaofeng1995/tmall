package com.hxf.mall.service;

import com.hxf.mall.entity.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    public List<PropertyValue> getPropertyValues(Integer pid);

    public void updatePropertyValue(PropertyValue propertyValue);
}
