package dev.leandro.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.leandro.ecommerce.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
