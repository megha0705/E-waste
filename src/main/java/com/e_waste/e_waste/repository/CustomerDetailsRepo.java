package com.e_waste.e_waste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsEntity extends JpaRepository<CustomerDetailsEntity, Integer> {
}
