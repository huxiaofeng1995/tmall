package com.hxf.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxf.mall.entity.Property;
import com.hxf.mall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping(value = "categories/{cid}/properties")
    public PageInfo getProperties(@PathVariable Integer cid, @RequestParam(value = "start",defaultValue = "1")int start, @RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(start, size);
        PageInfo<Property> page = new PageInfo<>(propertyService.getProperties(cid));
        return page;
    }
}
