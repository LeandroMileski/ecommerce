package dev.leandro.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.leandro.ecommerce.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
