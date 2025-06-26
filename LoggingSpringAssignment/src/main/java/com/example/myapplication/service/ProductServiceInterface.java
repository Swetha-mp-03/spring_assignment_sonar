package com.example.myapplication.service;

import com.example.myapplication.dto.ProductDTO;

import java.util.List;

public interface ProductServiceInterface {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    ProductDTO saveProduct(ProductDTO productDTO);

    boolean deleteProduct(Long id); // New method added
}
