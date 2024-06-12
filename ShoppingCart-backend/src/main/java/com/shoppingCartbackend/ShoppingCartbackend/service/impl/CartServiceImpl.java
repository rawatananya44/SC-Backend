package com.shoppingCartbackend.ShoppingCartbackend.service.impl;

import com.shoppingCartbackend.ShoppingCartbackend.dto.CartDto;
import com.shoppingCartbackend.ShoppingCartbackend.dto.ItemRequest;
import com.shoppingCartbackend.ShoppingCartbackend.entity.Cart;
import com.shoppingCartbackend.ShoppingCartbackend.entity.CartItem;
import com.shoppingCartbackend.ShoppingCartbackend.entity.Product;
import com.shoppingCartbackend.ShoppingCartbackend.repository.CartRepository;
import com.shoppingCartbackend.ShoppingCartbackend.repository.ProductRepository;
import com.shoppingCartbackend.ShoppingCartbackend.service.CartService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CartDto addItem(ItemRequest requestItem) {

        Long productId = requestItem.getProdId();
        int quantity = requestItem.getQuantity();

//      fetch product
        Product product = this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found"));

//       checking product stock
//        if(product.getInStock()==false){
//            new ResourceNotFoundException("Product is Out of Stock");
//        }

//        create cart item with product id and quantity
        Cart cart = new Cart();
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        double totalPrice = product.getPrice()*requestItem.getQuantity();
        cartItem.setTotalPrice(totalPrice);

//      getting cart and cart item set
        Set<CartItem> cartItemSet = new HashSet<>();
        cartItemSet.add(cartItem);
        cartItem.setCart(cart);
        cart.setItems(cartItemSet);

        Cart saveCart =this.cartRepository.save(cart);
        CartDto saveCartDto =  this.modelMapper.map(saveCart,CartDto.class);
        return saveCartDto;
    }
}
