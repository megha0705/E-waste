package com.e_waste.e_waste.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class SellerDocument {
    private int document_id;
    @ManyToOne
    private SellerPD seller_id;
    private String  document_url;
    private DocStatus status;
    @CreationTimestamp  // Automatically sets the current timestamp
    @Column(name = "uploaded_at", updatable = false)
    private LocalDateTime uploadedAt;
}
