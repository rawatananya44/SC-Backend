package com.shoppingCartbackend.ShoppingCartbackend.mapper;

import com.shoppingCartbackend.ShoppingCartbackend.dto.ProductDto;
import com.shoppingCartbackend.ShoppingCartbackend.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getProdId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getDescription(),
                product.getStockCount(),
                product.getInStock()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getProdID(),
                productDto.getName(),
                productDto.getCategory(),
                productDto.getPrice(),
                productDto.getDescription(),
                productDto.getStockCount(),
                productDto.getInStock()
        );
    }
}
