package com.e_waste.e_waste.entity;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class SellerPD {
    private int seller_id;
    @ManyToOne
    private UserSignUpEntity real_id;
    private String pan_number;
    private String pan_name;
    private String shop_name;
    private String business_category;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    @OneToMany(mappedBy = "seller_id", cascade = CascadeType.ALL)
    private List<SellerDocument> sellerDocs;
    @OneToMany(mappedBy = "seller_id", cascade = CascadeType.ALL)
    private List<SellerBankDetails> sellerBank;
}
