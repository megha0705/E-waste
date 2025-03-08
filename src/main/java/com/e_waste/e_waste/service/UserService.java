package com.e_waste.e_waste.service;

import com.e_waste.e_waste.entity.Role;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    public void createUser(String name , String email, String password, Role role);
    public void  userIdProof(String gstNumber, String pan_number , int userRealId);
    public void userIdProofDocs(String IDProofPathUrl);
}
