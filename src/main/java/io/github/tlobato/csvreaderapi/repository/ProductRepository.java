package io.github.tlobato.csvreaderapi.repository;

import io.github.tlobato.csvreaderapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByCodeIgnoreCase(String code);
}