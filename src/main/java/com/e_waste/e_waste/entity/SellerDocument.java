package com.e_waste.e_waste.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SellerDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int document_id;
    @ManyToOne
    private SellerPD seller_id;
    private String  document_url;
    private DocStatus status;
    @CreationTimestamp  // Automatically sets the current timestamp
    @Column(name = "uploaded_at", updatable = false)
    private LocalDateTime uploadedAt;

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public SellerPD getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(SellerPD seller_id) {
        this.seller_id = seller_id;
    }

    public String getDocument_url() {
        return document_url;
    }

    public void setDocument_url(String document_url) {
        this.document_url = document_url;
    }

    public DocStatus getStatus() {
        return status;
    }

    public void setStatus(DocStatus status) {
        this.status = status;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
