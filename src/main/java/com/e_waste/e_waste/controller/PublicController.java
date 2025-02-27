package com.e_waste.e_waste.controller;

import com.e_waste.e_waste.entity.Role;
import com.e_waste.e_waste.entity.UserSignUpEntity;
import com.e_waste.e_waste.service.UserService;
import com.e_waste.e_waste.serviceImp.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RequestMapping("user")
@RestController
public class PublicController {
    @Autowired
    UserService s;
    //postman
 /*  @PostMapping
    public String userCreate(@RequestBody UserSignUpEntity data) {
      ///System.out.println("the name is ____" + data.getName());
        s.createUser(data.getName(),data.getEmail(), data.getPassword(), data.getRole());
        return "hello";
    }*/
  @PostMapping
    public String userCreate(@RequestParam String name , @RequestParam String email, @RequestParam String password, @RequestParam Role role){
        s.createUser(name , email, password, role);
        return "successful registration";

    }
}
