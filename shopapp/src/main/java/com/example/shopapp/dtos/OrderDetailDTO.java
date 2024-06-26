package com.example.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1, message = "Order Id must be greater than 1")
    private Long orderId;

    @JsonProperty("product_id")
    @Min(value = 1, message = "Product Id must be greater than 1")
    private Long productId;

    @Min(value = 0, message = "Product Id must be greater than 0")
    private Float price;

    @JsonProperty("number_of_products")
    @Min(value = 1, message = "Number of Products must be greater than or equals 1")
    private Integer numberOfProducts;

    @JsonProperty("total_money")
    @Min(value = 0, message = "Total Money must be greater than or equals 0")
    private Float totalMoney;

    private String color;
}
