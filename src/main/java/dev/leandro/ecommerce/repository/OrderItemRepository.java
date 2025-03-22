package dev.leandro.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.leandro.ecommerce.entities.OrderItemEntity;
import dev.leandro.ecommerce.entities.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemId> {
}
