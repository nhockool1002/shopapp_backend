package com.example.shopapp.repositories;

import com.example.shopapp.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByUserId(Long userId);
}
