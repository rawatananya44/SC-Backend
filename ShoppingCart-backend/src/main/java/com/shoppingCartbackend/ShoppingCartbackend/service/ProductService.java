package com.shoppingCartbackend.ShoppingCartbackend.service;

import com.shoppingCartbackend.ShoppingCartbackend.dto.ProductDto;
import com.shoppingCartbackend.ShoppingCartbackend.dto.RequestDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(RequestDto productDto);
    ProductDto getProductById(Long prodId);
    List<ProductDto> getAllProduct();
    ProductDto updateProduct(Long prodId, ProductDto updatedProduct);
    void deleteProduct(Long prodId);



}
