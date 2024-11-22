/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Intel
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByUniquecode(String uniquecode);
}
