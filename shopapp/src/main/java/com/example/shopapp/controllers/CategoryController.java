package com.example.shopapp.controllers;

import com.example.shopapp.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
public class CategoryController {
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page")   int page,
            @RequestParam("limit")  int limit
    ) {
        return ResponseEntity.ok(String.format("Get All Categories API, Page is %d, Limit is %d", page, limit));
    }

    @PostMapping("")
    public ResponseEntity<?> insertCategory(
            @Valid @RequestBody CategoryDTO categoryDTO,
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
        return ResponseEntity.ok("Insert Category");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id) {
        return ResponseEntity.ok("Update Category: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCCategory(@PathVariable Long id) {
        return ResponseEntity.ok("Delete Category: " + id);
    }
}
