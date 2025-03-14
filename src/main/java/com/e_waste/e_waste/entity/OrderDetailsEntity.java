package com.e_waste.e_waste.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int order_id;
    @ManyToOne
    private SellerPD seller_id;

    @ManyToOne
    private CustomerEntity customer_id;
    private double total_price;
    private OrderStatus orderStatus;
    private LocalDateTime created_at;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public SellerPD getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(SellerPD seller_id) {
        this.seller_id = seller_id;
    }

    public CustomerEntity getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(CustomerEntity customer_id) {
        this.customer_id = customer_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
