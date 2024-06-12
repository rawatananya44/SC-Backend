package com.shoppingCartbackend.ShoppingCartbackend.service.impl;

import com.shoppingCartbackend.ShoppingCartbackend.Enum.Category;
import com.shoppingCartbackend.ShoppingCartbackend.dto.ProductDto;
import com.shoppingCartbackend.ShoppingCartbackend.dto.RequestDto;
import com.shoppingCartbackend.ShoppingCartbackend.entity.Product;
import com.shoppingCartbackend.ShoppingCartbackend.mapper.ProductMapper;
import com.shoppingCartbackend.ShoppingCartbackend.repository.ProductRepository;
import com.shoppingCartbackend.ShoppingCartbackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private ModelMapper modelMapper;

    public Product findById(Long prodId){
        return productRepository.findById(prodId).orElseThrow(()-> new ResourceNotFoundException("Product does not exist with given ID: " + prodId));
    }
    @Override
    public ProductDto createProduct(RequestDto productDto) {
//        convert product dto to jpa entity
//        saving product jpa entity into database, using .save() method in repository class
//        which returns an entity to taking that into a variable and then converting entity variable again
//       to dto for the client
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long prodId) {
        Product product = productRepository.findById(prodId)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with given ID : " + prodId));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map(product -> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long prodId, ProductDto updatedProduct) {
        Product product = findById(prodId);

        product.setName(updatedProduct.getName());
        product.setCategory(updatedProduct.getCategory());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setStockCount(updatedProduct.getStockCount());
        product.setInStock(updatedProduct.getInStock());

        Product updatedProductObject = productRepository.save(product);

        return ProductMapper.mapToProductDto(updatedProductObject);
    }

    @Override
    public void deleteProduct(Long prodId) {
        Product product =  findById(prodId);
        productRepository.deleteById(prodId);
    }


}
