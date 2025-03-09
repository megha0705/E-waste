package com.e_waste.e_waste.controller;

import com.e_waste.e_waste.documentManage.DocStoring;
import com.e_waste.e_waste.entity.Role;
import com.e_waste.e_waste.entity.UserSignUpEntity;
import com.e_waste.e_waste.repository.UserRepo;
import com.e_waste.e_waste.serviceImp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//import static com.sun.beans.introspect.PropertyInfo.Name.required;


@RestController
public class AuthController {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        @Autowired
        UserImp s;
        @Autowired
        UserRepo repo;
        @Autowired
        DocStoring file;
        int userRealId = 1;
        @PostMapping("/login")
        public String loginUser(@RequestParam String name , @RequestParam String password){
                UserSignUpEntity user = repo.findByName(name);
                String bycrptPassword = user.getPassword();
                if(user != null && passwordEncoder.matches(password , bycrptPassword)){
                         userRealId = user.getId();
                        String role = String.valueOf(user.getRole());
                        if(role.equals("SELLER")){
                                return " you are a seller!!!";
                        }

                }
                return "idk bro";
                //redirect to another page
        }
        @PostMapping("/IdProof")
        public String identificationProof(@RequestParam(required = false) String gstNumber
                , @RequestParam(required = false) String pan_number
                , @RequestParam(required = false) MultipartFile panCard
                , @RequestParam(required =false) MultipartFile gstCard ) throws IOException {

                if((gstNumber != null && gstCard != null && !gstCard.isEmpty()) || (pan_number != null && panCard != null && !panCard.isEmpty())){
                        String filePathUrl = " ";
                        if(gstCard !=null && !gstCard.isEmpty()){
                          filePathUrl =   file.fileSaving(gstCard);
                           s.userIdProof(gstNumber,pan_number,userRealId);
                           s.userIdProofDocs(filePathUrl);
                        }
                        else if (panCard != null && !panCard.isEmpty()){
                          filePathUrl =    file.fileSaving(panCard);
                          s.userIdProof(gstNumber,pan_number,userRealId);
                          s.userIdProofDocs(filePathUrl);
                }
                }
                return "worked succesfully";
        }
}
