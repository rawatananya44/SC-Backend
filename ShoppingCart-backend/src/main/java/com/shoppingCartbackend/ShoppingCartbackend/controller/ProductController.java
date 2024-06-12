package com.shoppingCartbackend.ShoppingCartbackend.controller;

import com.shoppingCartbackend.ShoppingCartbackend.dto.ProductDto;
import com.shoppingCartbackend.ShoppingCartbackend.dto.RequestDto;
import com.shoppingCartbackend.ShoppingCartbackend.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
//    Build add product rest api
    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody RequestDto productDto){
        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
//   Build rest api for get all products
    @GetMapping("/viewAllProducts")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> allProducts = productService.getAllProduct();
        return new ResponseEntity<List<ProductDto>>(allProducts, HttpStatus.ACCEPTED);
    }
//    Build get product rest api
    @GetMapping("/viewProductById/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long prodId){
        ProductDto productDto = productService.getProductById(prodId);
        return ResponseEntity.ok(productDto);
    }

//    Build update product rest api
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductDto> updatedProduct(@Valid @PathVariable("id") Long prodId, @RequestBody ProductDto updatedProduct){
        ProductDto productDto = productService.updateProduct(prodId, updatedProduct);
        return new ResponseEntity<ProductDto>(productDto,HttpStatus.ACCEPTED);
    }
//    Build delete rest api
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long prodId){
        productService.deleteProduct(prodId);
        return ResponseEntity.ok("Product deleted successfully");
    }


}
