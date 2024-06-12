package com.shoppingCartbackend.ShoppingCartbackend.service;

import com.shoppingCartbackend.ShoppingCartbackend.dto.CartDto;
import com.shoppingCartbackend.ShoppingCartbackend.dto.ItemRequest;

public interface CartService {
    CartDto addItem(ItemRequest item);
}
