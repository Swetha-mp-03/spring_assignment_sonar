package com.example.myapplication.service;

import com.example.myapplication.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService implements ProductServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final List<ProductDTO> products = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public List<ProductDTO> getAllProducts() {
        logger.info("Fetching all products");
        return new ArrayList<>(products);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        logger.info("Fetching product with id: {}", id);
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        if (productDTO.getId() == null) {
            productDTO.setId(idGenerator.incrementAndGet());
            products.add(productDTO);
            logger.info("Added new product with id: {}", productDTO.getId());
        } else {
            products.removeIf(product -> product.getId().equals(productDTO.getId()));
            products.add(productDTO);
            logger.info("Updated product with id: {}", productDTO.getId());
        }
        return productDTO;
    }

    @Override
    public boolean deleteProduct(Long id) {
        boolean removed = products.removeIf(product -> product.getId().equals(id));
        if (removed) {
            logger.info("Deleted product with id: {}", id);
        } else {
            logger.warn("Product with id: {} not found for deletion", id);
        }
        return removed;
    }
}
