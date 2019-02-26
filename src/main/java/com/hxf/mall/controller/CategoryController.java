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

    @RequestMapping(value = "categories/{id}",method = RequestMethod.DELETE)
    public String delCategory(@PathVariable Integer id, HttpServletRequest request){
        String uploadPath = request.getServletContext().getRealPath("img/category");
        categoryService.delete(id);
        File file = new File(uploadPath, id +".jpg");
        if(file.getParentFile().exists()){
            file.delete();
        }
        return null;
    }

    @RequestMapping(value = "categories/{id}",method = RequestMethod.GET)
    public Category getCategory(@PathVariable Integer id, HttpServletRequest request){
        return categoryService.getCategoryById(id);
    }

    @RequestMapping(value = "categories/{id}",method = RequestMethod.PUT)
    public Category updateCategory(@PathVariable Integer id, Category category, MultipartFile image, HttpServletRequest request){
        //这里获取参数用的是 request.getParameter("name"). 为什么不用 add里的注入一个 Category对象呢？ 因为。。。PUT 方式注入不了
        String name = request.getParameter("name");
        category.setId(id);
        category.setName(name);
        categoryService.update(category);
        //如果选择了上传图片，就更新图片，如果没有选择，就保留原图片不变
        if(image != null) {
            String uploadPath = request.getServletContext().getRealPath("img/category");

            File file = new File(uploadPath, category.getId() + ".jpg");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                image.transferTo(file);
                BufferedImage img = ImageUtil.change2jpg(file);
                ImageIO.write(img, "jpg", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return category;
    }
}
