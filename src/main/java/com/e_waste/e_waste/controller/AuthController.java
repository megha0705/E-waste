package com.e_waste.e_waste.controller;

import com.e_waste.e_waste.documentManage.DocStoring;
import com.e_waste.e_waste.entity.Role;
import com.e_waste.e_waste.entity.SellerPD;
import com.e_waste.e_waste.entity.UserSignUpEntity;
import com.e_waste.e_waste.repository.SellerPdRepo;
import com.e_waste.e_waste.repository.UserRepo;
import com.e_waste.e_waste.serviceImp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//import static com.sun.beans.introspect.PropertyInfo.Name.required;


@RestController
public class AuthController {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        @Autowired
        UserImp s;
        @Autowired
        SellerPdRepo pdRepo;
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
                                //here  i wil check whether the seller has the registered id if no then redirect them to the verification process
                                //if yes then redirect them to their dashboard.
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
        @PutMapping("uniId/{id}")
        public String itemDetails(@PathVariable int id ,
                                  @RequestParam String shop_name
                                  ,@RequestParam String business_category,
                                  @RequestParam String address ,
                                  @RequestParam String city ,
                                  @RequestParam String pincode ,
                                  @RequestParam String state){
                SellerPD seller_personal_Details = pdRepo.findById(id).orElse(null);
                seller_personal_Details.setBusiness_category(business_category);
                seller_personal_Details.setAddress(address);
                seller_personal_Details.setPinCode(pincode);
                seller_personal_Details.setState(state);
                seller_personal_Details.setCity(city);
                seller_personal_Details.setShop_name(shop_name);
                pdRepo.save(seller_personal_Details);
                return "personal details has been saved succesfully";

        }
        @PostMapping("bankDetails")
        public String sellerBankDetails(@RequestParam String account_holder_name ,
                                        @RequestParam String bank_name ,
                                        @RequestParam String account_number,
                                        @RequestParam String ifsc_code){

                s.sellerBankDetails(account_holder_name , bank_name , account_number , ifsc_code);
                return "bank details has been saved successfully";
        }
}
