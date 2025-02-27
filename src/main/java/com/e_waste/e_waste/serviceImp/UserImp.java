package com.e_waste.e_waste.serviceImp;

import com.e_waste.e_waste.entity.Role;
import com.e_waste.e_waste.entity.UserSignUpEntity;
import com.e_waste.e_waste.repository.UserRepo;
import com.e_waste.e_waste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImp implements UserService {
    @Autowired
    UserRepo repo;

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
}
