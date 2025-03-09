package com.e_waste.e_waste.serviceImp;

import com.e_waste.e_waste.documentManage.DocStoring;
import com.e_waste.e_waste.entity.*;
import com.e_waste.e_waste.repository.SellerDocsRepo;
import com.e_waste.e_waste.repository.SellerPdRepo;
import com.e_waste.e_waste.repository.UserRepo;
import com.e_waste.e_waste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserImp implements UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    DocStoring files;

    @Autowired
    SellerPdRepo sellerPdRepo;
    @Autowired
    SellerDocsRepo sellerDocsRepo;
    public static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public void createUser(String name, String email, String password, Role role) {
        UserSignUpEntity user = new UserSignUpEntity();
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setName(name);
        user.setRole(role);
        repo.save(user);


    }
    int UID = 0;
    @Override
    public void userIdProof(String gstNumber, String pan_number,  int userRealId) {
        SellerPD sellerIdProof = new SellerPD();
        UserSignUpEntity user = repo.findById(userRealId).orElse(null);
        sellerIdProof.setGst_number(gstNumber);
        sellerIdProof.setPan_number(pan_number);
        sellerIdProof.setReal_id(user);

        sellerPdRepo.save(sellerIdProof);
        UID = sellerIdProof.getSeller_id();
    }

    @Override
    public void userIdProofDocs(String IDProofPathUrl) {
        SellerDocument seller_OG_Docs = new SellerDocument();
        SellerPD sellerPersonalDetailsEnity = sellerPdRepo.findById(UID).orElse(null);
        seller_OG_Docs.setDocument_url(IDProofPathUrl);
        seller_OG_Docs.setStatus(DocStatus.VERIFIED);
        seller_OG_Docs.setSeller_id(sellerPersonalDetailsEnity);
        sellerDocsRepo.save(seller_OG_Docs);
    }
}
