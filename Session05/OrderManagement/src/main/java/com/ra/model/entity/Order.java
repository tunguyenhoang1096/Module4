package com.ra.model.entity;

import com.ra.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_code")
    private String orderCode;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name = "created_at")
    private LocalDate createdAt;
}
