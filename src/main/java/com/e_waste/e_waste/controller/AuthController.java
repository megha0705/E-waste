package com.e_waste.e_waste.controller;

import com.e_waste.e_waste.entity.Role;
import com.e_waste.e_waste.entity.UserSignUpEntity;
import com.e_waste.e_waste.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        @Autowired
UserRepo repo;
        @PostMapping("/login")
        public String loginUser(@RequestParam String userName , @RequestParam String password){
                UserSignUpEntity user = repo.findByName(userName);
                String bycrptPassword = user.getPassword();
                if(user != null && passwordEncoder.matches(password , bycrptPassword)){
                        String role = String.valueOf(user.getRole());
                        if(role.equals("SELLER")){
                                return " you are a seller!!!";
                        }

                }
                return "idk bro";
        }

}
