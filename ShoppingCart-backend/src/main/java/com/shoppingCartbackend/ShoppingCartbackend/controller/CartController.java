package com.shoppingCartbackend.ShoppingCartbackend.controller;

import com.shoppingCartbackend.ShoppingCartbackend.dto.CartDto;
import com.shoppingCartbackend.ShoppingCartbackend.dto.ItemRequest;
import com.shoppingCartbackend.ShoppingCartbackend.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @PostMapping
    public ResponseEntity<CartDto> addToCart(@RequestBody ItemRequest itemRequest){
        CartDto addItem = cartService.addItem(itemRequest);
        return new ResponseEntity<CartDto>(addItem, HttpStatus.OK);
    }

}
