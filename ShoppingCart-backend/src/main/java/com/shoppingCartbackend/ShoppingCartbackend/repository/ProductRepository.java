package com.shoppingCartbackend.ShoppingCartbackend.repository;

import com.shoppingCartbackend.ShoppingCartbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
}
