package com.e_waste.e_waste.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SellerBankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private SellerPD seller_id;
    private String account_holder_name;
    private String bank_name;
    private String account_number;
    private String ifsc_code;

}
