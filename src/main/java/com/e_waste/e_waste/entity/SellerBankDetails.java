package com.e_waste.e_waste.entity;

import javax.persistence.ManyToOne;

public class SellerBankDetails {
    private int id;
    @ManyToOne
    private SellerPD seller_id;
    private String account_holder_name;
    private String bank_name;
    private String account_number;
    private String ifsc_code;

}
