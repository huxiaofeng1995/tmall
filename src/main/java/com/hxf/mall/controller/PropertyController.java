package com.hxf.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxf.mall.entity.Property;
import com.hxf.mall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("properties")
    public String addProperty(@RequestBody Property property){//前端传参格式为json，则这里要用RequstBody来接收
        propertyService.addProperty(property);
        return "success";
    }

    @DeleteMapping("properties/{id}")
    public String delProperty(@PathVariable Integer id){
        propertyService.delProperty(id);
        return null;
    }
}
