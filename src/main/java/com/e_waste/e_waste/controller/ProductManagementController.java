package com.e_waste.e_waste.controller;

import com.e_waste.e_waste.documentManage.ProductImgHandle;
import com.e_waste.e_waste.entity.ProductDetailsEntity;
import com.e_waste.e_waste.entity.ProductStatus;
import com.e_waste.e_waste.repository.ProductDetailsRepo;
import com.e_waste.e_waste.serviceImp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RequestMapping("/seller/product")
@RestController
public class ProductManagementController {
    @Autowired
    ProductImgHandle productImg;
    @Autowired
    UserImp s;
    @Autowired
    ProductDetailsRepo productRepo;
    //Adding individual products
    @PostMapping("/add")
    public void addProduct(@RequestParam String name ,
                            @RequestParam String description ,
                            @RequestParam String category ,
                            @RequestParam double price,
                            @RequestParam int stock_quantity,
                            @RequestParam (required = false)ProductStatus status,
                            @RequestParam MultipartFile  image
                            )throws IOException {
      String imgUrl =   productImg.productImgStore(image);
      s.addProducts(name , description , category , price, stock_quantity, status, imgUrl);
    }
    //getting all the products available
    @GetMapping("getAll")
    public List<ProductDetailsEntity> getAllProducts(){
        return productRepo.findAll();
    }
    //upodate specific product details

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id ,
                                @RequestParam (required = false)String name ,
                                @RequestParam (required = false)String description,
                                @RequestParam (required = false)String category,
                                @RequestParam(required = false) Double price,
                                @RequestParam (required = false)Integer stock_quantity,
                                @RequestParam (required = false)ProductStatus status,
                                @RequestParam (required = false)MultipartFile  image
                                )throws IOException{
        ProductDetailsEntity productDetails = productRepo.findById(id).orElseThrow(()-> new RuntimeException("object not found"));
        if(name != null){
            productDetails.setName(name);
        }
        if(description != null){
            productDetails.setDescription(description);
        }
        if(category != null){
            productDetails.setCategory(category);
        }
        if( price != null){
            productDetails.setPrice(price);
        }
        if(stock_quantity != null){
            productDetails.setStock_quantity(stock_quantity);
        }
        if(status != null){
            productDetails.setStatus(status);
        }
        if(image != null){
          String imgUrl =  productImg.productImgStore(image);
          productDetails.setImage_url(imgUrl);
        }
        productRepo.save(productDetails);
        return "product has been updated succesfully";
    }
}
