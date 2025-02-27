package com.e_waste.e_waste.repository;

import com.e_waste.e_waste.entity.UserSignUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserSignUpEntity, Integer> {
    public UserSignUpEntity findByName(String name);
}
