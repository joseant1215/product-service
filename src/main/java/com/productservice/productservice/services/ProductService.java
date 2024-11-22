/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productservice.productservice.services;

import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Intel
 */
@Service
public class ProductService {
     @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getClientByCode(String uniquecode) {
        System.out.println("Buscando Product con código único en el servicio: " + uniquecode);

        // Llamar al repositorio para buscar por uniquecode
        Optional<Product> product = productRepository.findByUniquecode(uniquecode);

        if (product.isPresent()) {
            System.out.println("Product encontrado en el servicio: " + product.get());
        } else {
            System.out.println("Product no encontrado en el servicio");
        }

        return product;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
