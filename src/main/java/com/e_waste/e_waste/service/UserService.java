package com.e_waste.e_waste.service;

import com.e_waste.e_waste.entity.Role;

public interface UserService {
    public void createUser(String name , String email, String password, Role role);
}
