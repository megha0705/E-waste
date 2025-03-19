package com.e_waste.e_waste.documentManage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class DocStoring {
    public String fileSaving(MultipartFile doc) throws IOException {
        String directory = "C:/Users/Reshmi Chakraborty/OneDrive/Desktop/coding/projects/e-waste/src/main/java/com/e_waste/e_waste/rawDocuments";
        File folder = new File(directory);
        if(!folder.exists()){
            folder.mkdirs();
        }
        File f1 = new File(directory , doc.getOriginalFilename());
        doc.transferTo(f1);
        String filePathUrl = "e-waste/src/main/java/com/e_waste/e_waste/" + doc.getOriginalFilename();

        System.out.println("file has been succesfully transferred");

        return filePathUrl;

    }
}
