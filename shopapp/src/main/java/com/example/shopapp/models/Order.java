package com.example.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "fullname", length = 100, nullable = true)
    private String fullName;

    @Column(name = "email", length = 100, nullable = true)
    private String email;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "note", length = 200, nullable = true)
    private String note;

    @Column(name = "order_date", nullable = false, updatable = false)
    private LocalDateTime orderDate;

    @Column(name = "status", nullable = true, columnDefinition = "ENUM('pending', 'processing', 'shipped', 'delivered', 'cancelled')")
    private String status;

    @Column(name = "total_money", nullable = true)
    private Float totalMoney;

    @Column(name = "shipping_method", length = 100, nullable = true)
    private String shippingMethod;

    @Column(name = "shipping_address", length = 200, nullable = true)
    private String shippingAddress;

    @Column(name = "shipping_date", nullable = true)
    private Date shippingDate;

    @Column(name = "tracking_number", length = 100, nullable = true)
    private String trackingNumber;

    @Column(name = "payment_method", length = 100, nullable = true)
    private String paymentMethod;

    @Column(name = "active", nullable = false)
    private Boolean active;
}
