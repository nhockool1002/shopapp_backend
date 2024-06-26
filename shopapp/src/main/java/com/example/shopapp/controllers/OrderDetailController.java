package com.example.shopapp.controllers;

import com.example.shopapp.dtos.OrderDTO;
import com.example.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/order_detail")
public class OrderDetailController {
    @PostMapping("")
    public ResponseEntity<?> insertOrderDetail(
            @Valid @RequestBody OrderDetailDTO orderDetailDTO,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            List<String> errorMessage;
            errorMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        return ResponseEntity.ok("Insert Order Details");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrderDetail(@Valid @PathVariable Long id) {
        try {
            return ResponseEntity.ok("Request all orders detail by id: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<String> getOrderDetailByOrderId(@Valid @PathVariable Long orderId) {
        try {
            return ResponseEntity.ok("Request all orders detail by order id: " + orderId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrderDetail(
            @PathVariable Long id,
            @RequestBody OrderDetailDTO orderDetailDTO
    ) {
        return ResponseEntity.ok("Update Order: " + id + ", new data: " + orderDetailDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderDetail(@PathVariable Long id) {
        return ResponseEntity.ok("Delete Order: " + id);
    }
}
