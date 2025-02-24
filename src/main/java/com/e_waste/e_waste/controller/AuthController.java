package com.e_waste.e_waste.controller;

import com.e_waste.e_waste.entity.Role;
import com.e_waste.e_waste.entity.UserSignUpEntity;
import com.e_waste.e_waste.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserRepo repo;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @PostMapping ("login")
    public String loginUser(@RequestParam String userName , @RequestParam String password){

       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      System.out.println(userName + password);
       UserSignUpEntity userEntity = repo.findByName(userName);
        if(userEntity != null && passwordEncoder.matches(password , userEntity.getPassword())){
            Role role = userEntity.getRole();
            String r = String.valueOf(role);
            if(r.equals("SELLER")){
                return "you are a seller";
            }
        }
        return "idk bro"; //reponse Entity 200;
    }

}

