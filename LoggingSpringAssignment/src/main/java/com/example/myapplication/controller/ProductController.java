package com.example.myapplication.controller;

import com.example.myapplication.dto.ProductDTO;
import com.example.myapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Display the list of products.
     */
    @GetMapping("/list")
    public String listProducts(Model model) {
        List<ProductDTO> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "products"; // JSP file: products.jsp
    }
    /**
     * Display product details by ID.
     */
    @GetMapping("/{id}")
    public String getProductDetails(@PathVariable Long id, Model model) {
        ProductDTO product = productService.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
        } else {
            model.addAttribute("errorMessage", "Product not found!");
        }
        return "product-detail"; // Render product-detail.jsp
    }

    /**
     * Display the form to add or edit a product.
     */
    @GetMapping("/form")
    public String showProductForm(@RequestParam(required = false) Long id, Model model) {
        ProductDTO product = (id != null) ? productService.getProductById(id) : new ProductDTO();
        model.addAttribute("product", product);
        return "product-form"; // Render product-form.jsp
    }

    /**
     * Handle the form submission for adding or editing a product.
     */
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductDTO product) {
        productService.saveProduct(product);
        return "redirect:/product/list"; // Redirect to product list
    }

    /**
     * Delete a product by ID.
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/list"; // Redirect to product list
    }
}
