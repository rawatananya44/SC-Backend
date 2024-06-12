package com.shoppingCartbackend.ShoppingCartbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Long cartItemId;
    private int quantity;
    private double totalPrice;
    private CartDto cartDto;
    private ProductDto productDto;
}
