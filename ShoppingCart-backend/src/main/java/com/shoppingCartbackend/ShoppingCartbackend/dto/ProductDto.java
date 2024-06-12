package com.shoppingCartbackend.ShoppingCartbackend.dto;

import com.shoppingCartbackend.ShoppingCartbackend.Enum.Category;
import com.shoppingCartbackend.ShoppingCartbackend.Enum.InStock;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    private Long prodID;

    @NotEmpty
    @Size(min = 3, max = 50, message = "Name should contain min 3 and max 20 characters")
    private String name;

//    @NotEmpty
//    @Size(min = 2, max=20, message = "Category should contain min 2 and max 20 characters")
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    @Min(0)
    @Max(10000000)
    private double price;

    @NotEmpty
    @Size(min = 3, max=250, message = "Description should contain min 3 and max 250 characters")
    private String description;

    @NotNull
    @Min(1)
    @Max(50000)
    private Integer stockCount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private InStock inStock;
}
