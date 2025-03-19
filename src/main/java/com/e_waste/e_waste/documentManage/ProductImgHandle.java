package com.e_waste.e_waste.documentManage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class ProductImgHandle {

    public  String productImgStore(MultipartFile img)throws IOException {
        String directory = "C:/Users/Reshmi Chakraborty/OneDrive/Desktop/coding/projects/e-waste/src/main/java/com/e_waste/e_waste/productImgs";
        File folder = new File(directory);
        if(!folder.exists()){
            folder.mkdirs();

        }

        File file = new File(directory, img.getOriginalFilename());
        img.transferTo(file);
        String imgUrl = directory + "/" + img.getOriginalFilename();
        System.out.println("the product img has been saved succesfully");
        return imgUrl;
    }
}
