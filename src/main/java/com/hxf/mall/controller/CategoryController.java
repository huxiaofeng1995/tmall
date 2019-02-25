package com.hxf.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxf.mall.entity.Category;
import com.hxf.mall.service.CategoryService;
import com.hxf.mall.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    /**
     * @start 当前页数
     * @size 每页个数
     */
    @RequestMapping(value = "categories", method = RequestMethod.GET)
    public PageInfo getAll(@RequestParam(value = "start",defaultValue = "1")int start, @RequestParam(value = "size",defaultValue = "5")int size){
        PageHelper.startPage(start,size);
        PageInfo<Category> page = new PageInfo<>(categoryService.listAll());
        return page;
    }

    @RequestMapping(value = "categories",method = RequestMethod.POST)
    public Category addCategory(Category category, MultipartFile image, HttpServletRequest request){
        String uploadPath = request.getServletContext().getRealPath("img/category");
        categoryService.add(category);
        File file = new File(uploadPath, category.getId()+".jpg");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return category;
    }

}
