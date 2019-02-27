package com.hxf.mall.dao;


import com.hxf.mall.entity.PropertyValue;

import java.util.List;

public interface PropertyValueMapper {
    List<PropertyValue> select_propertyvalue_list_by_pid(Integer pid);

    void update_propertyvalue(PropertyValue propertyValue);
}
