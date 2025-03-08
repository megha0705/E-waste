package com.e_waste.e_waste.repository;

import com.e_waste.e_waste.entity.SellerPD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerPdRepo  extends JpaRepository<SellerPD , Integer> {
}
