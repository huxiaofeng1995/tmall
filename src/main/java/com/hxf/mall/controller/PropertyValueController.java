package com.hxf.mall.controller;

import com.hxf.mall.entity.PropertyValue;
import com.hxf.mall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {

    @Autowired
    private PropertyValueService propertyValueService;

    @GetMapping("products/{pid}/propertyValues")
    public List<PropertyValue> getPropertyValues(@PathVariable Integer pid){
        return propertyValueService.getPropertyValues(pid);
    }

    @PutMapping("propertyValues")
    public PropertyValue updatePropertyValue(@RequestBody PropertyValue propertyValue){
        propertyValueService.updatePropertyValue(propertyValue);
        return propertyValue;
    }

}
