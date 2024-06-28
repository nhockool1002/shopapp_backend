package com.example.shopapp.repositories;

import com.example.shopapp.models.Order;
import com.example.shopapp.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<OrderDetail> findByUserId(Long userId);
}
