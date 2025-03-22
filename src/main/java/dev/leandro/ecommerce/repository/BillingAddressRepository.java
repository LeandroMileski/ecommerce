package dev.leandro.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.leandro.ecommerce.entities.BillingAddressEntity;

public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, Long> {
}
