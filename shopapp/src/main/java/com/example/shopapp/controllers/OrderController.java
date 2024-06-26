package com.example.shopapp.controllers;

import com.example.shopapp.dtos.CategoryDTO;
import com.example.shopapp.dtos.OrderDTO;
import com.example.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    @GetMapping("")
    public ResponseEntity<String> getAllOrders(
            @RequestParam("page")   int page,
            @RequestParam("limit")  int limit
    ) {
        return ResponseEntity.ok(String.format("Get All Order API, Page is %d, Limit is %d", page, limit));
    }

    @PostMapping("")
    public ResponseEntity<?> insertOrder(
            @Valid @RequestBody OrderDTO orderDTO,
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
        return ResponseEntity.ok("Insert Order");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getOrders(@Valid @PathVariable Long userId) {
        try {
            return ResponseEntity.ok("Request all orders of user: " + userId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(
            @PathVariable Long id,
            @RequestBody OrderDTO orderDTO
    ) {
        return ResponseEntity.ok("Update Order: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok("Delete Order: " + id);
    }
}
