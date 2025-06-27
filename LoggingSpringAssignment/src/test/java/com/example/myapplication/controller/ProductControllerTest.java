package com.example.myapplication.controller;

import com.example.myapplication.dto.ProductDTO;
import com.example.myapplication.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetProductDetails_ProductNotFound() {
        when(productService.getProductById(1L)).thenReturn(null);

        String viewName = productController.getProductDetails(1L, model);

        assertEquals("product-detail", viewName);
        verify(model, times(1)).addAttribute("errorMessage", "Product not found!");
        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    void testShowProductForm_NewProduct() {
        String viewName = productController.showProductForm(null, model);

        assertEquals("product-form", viewName);
        verify(model, times(1)).addAttribute(eq("product"), any(ProductDTO.class));
    }

}