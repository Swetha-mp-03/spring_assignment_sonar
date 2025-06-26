package com.example.myapplication.service;

import com.example.myapplication.dto.ProductDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private final ProductService productService = new ProductService();

    @Test
    void testSaveAndGetProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Test Product");

        productService.saveProduct(productDTO);

        ProductDTO fetchedProduct = productService.getProductById(1L);
        assertNotNull(fetchedProduct);
        assertEquals("Test Product", fetchedProduct.getName());
    }

    @Test
    void testGetAllProducts() {
        ProductDTO product1 = new ProductDTO();
        product1.setId(1L);
        product1.setName("Product 1");

        ProductDTO product2 = new ProductDTO();
        product2.setId(2L);
        product2.setName("Product 2");

        productService.saveProduct(product1);
        productService.saveProduct(product2);

        List<ProductDTO> products = productService.getAllProducts();
        assertEquals(2, products.size());
    }
}
