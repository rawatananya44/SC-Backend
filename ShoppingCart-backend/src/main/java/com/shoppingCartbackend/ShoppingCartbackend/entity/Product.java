package com.shoppingCartbackend.ShoppingCartbackend.entity;

import com.shoppingCartbackend.ShoppingCartbackend.Enum.Category;
import com.shoppingCartbackend.ShoppingCartbackend.Enum.InStock;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_Id")
    private Long prodId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "category_name")
    private Category category;

    @Column(name = "prod_price")
    private double price;

    @Column(name = "prod_description")
    private String description;

    @Column(name = "stock_count")
    private Integer stockCount;

    @Column(name = "inStock")
    private InStock inStock;

}
