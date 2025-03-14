package com.e_waste.e_waste.controller;

import com.e_waste.e_waste.repository.SellerPdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/seller/dashboard")
@RestController
public class SellerDashboardController {
    @Autowired
    SellerPdRepo sellerPdRepo;
    @GetMapping("{sellerId}")
    public void getSellerDashboad(@PathVariable int sellerId){
    //first i need to make the product database to make the dashboard of the seller
    // i will fetchh the total orders , total earning , total products,

    }
}

