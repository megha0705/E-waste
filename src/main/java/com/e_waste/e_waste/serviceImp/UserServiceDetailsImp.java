package com.e_waste.e_waste.serviceImp;

import com.e_waste.e_waste.entity.UserSignUpEntity;
import com.e_waste.e_waste.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetailsImp implements UserDetailsService {
@Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSignUpEntity user = repo.findByName(username);
        if(user != null){
            return User.builder().username(user.getName()).password(user.getPassword()).roles(user.getRole().name()).build();
        }

        throw new UsernameNotFoundException("user is not found" + username);
    }
}
