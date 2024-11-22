/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productservice.productservice.controllers;

import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.ProductRepository;
import com.productservice.productservice.services.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Intel
 */

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        System.out.println("products recuperados: " + products);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{uniquecode}")
    public ResponseEntity<Product> getClient(@PathVariable String uniquecode) {

        System.out.println("Recibiendo código único: " + uniquecode);

        // Llamada al servicio
        Optional<Product> client = productService.getClientByCode(uniquecode);

        // Verifica si se encontró el cliente
        if (client.isPresent()) {
            System.out.println("Cliente encontrado: " + client.get());
            return ResponseEntity.ok(client.get()); // Retorna el cliente encontrado
        } else {
            System.out.println("Cliente no encontrado");
            return ResponseEntity.notFound().build(); // Retorna 404 si no se encuentra el cliente
        }
    }
}
