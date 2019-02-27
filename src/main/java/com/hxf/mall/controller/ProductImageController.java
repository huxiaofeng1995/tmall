package com.hxf.mall.controller;

import com.hxf.mall.entity.Product;
import com.hxf.mall.entity.ProductImage;
import com.hxf.mall.service.ProductImageService;
import com.hxf.mall.service.ProductService;
import com.hxf.mall.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ProductService productService;

    private static final String SINGLE = "single";

    private static final String DETAIL = "detail";

    @GetMapping("products/{pid}/productImages")
    public List<ProductImage> listProductImages(String type, @PathVariable Integer pid){
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("pid", pid);
        return productImageService.listProductImage(map);
    }

    @PostMapping("productImages")
    public ProductImage addProductImage(int pid, String type, MultipartFile image, HttpServletRequest request) throws Exception {
        ProductImage productImage = new ProductImage();
        Product product = productService.getProduct(pid);
        productImage.setProduct(product);
        productImage.setType(type);

        productImageService.addProductImage(productImage);
        String folder = "img/";
        if(SINGLE.equals(productImage.getType())){
            folder +="productSingle";
        }
        else{
            folder +="productDetail";
        }
        File imageFolder= new File(request.getServletContext().getRealPath(folder));
        File file = new File(imageFolder,productImage.getId()+".jpg");
        String fileName = file.getName();
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try {
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //用工具类改变单个图片的大小存在不同的文件夹
        if(SINGLE.equals(productImage.getType())){
            String imageFolder_small= request.getServletContext().getRealPath("img/productSingle_small");
            String imageFolder_middle= request.getServletContext().getRealPath("img/productSingle_middle");
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);
            f_small.getParentFile().mkdirs();
            f_middle.getParentFile().mkdirs();
            ImageUtil.resizeImage(file, 56, 56, f_small);
            ImageUtil.resizeImage(file, 217, 190, f_middle);
        }

        return productImage;
    }

    @DeleteMapping("productImages/{id}")
    public String delProductImage(@PathVariable Integer id, HttpServletRequest request){
        ProductImage productImage = productImageService.getProductImage(id);
        String imageType = productImage.getType();
        //删除数据库记录
        productImageService.delProductImage(id);
        //删除上传的图片，分类型删除
        if(DETAIL.equals(imageType)){
            String detailPath = request.getServletContext().getRealPath("img/productDetail");
            File file = new File(detailPath, id + ".jpg");
            if(file.exists()){
                file.delete();
            }
        }else {
            String singlePath = request.getServletContext().getRealPath("img/productSingle");
            File file = new File(singlePath, id + ".jpg");
            if(file.exists()){
                file.delete();
            }
            File file_middle = new File(singlePath + "_middle", id + ".jpg");
            file_middle.delete();
            File file_small = new File(singlePath + "_small", id + ".jpg");
            file_small.delete();
        }
        return null;
    }
}
