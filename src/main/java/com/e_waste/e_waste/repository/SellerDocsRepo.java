package com.e_waste.e_waste.repository;

import com.e_waste.e_waste.entity.SellerDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDocsRepo extends JpaRepository<SellerDocument , Integer> {
}
