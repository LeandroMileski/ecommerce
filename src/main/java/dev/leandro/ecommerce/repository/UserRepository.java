package dev.leandro.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.leandro.ecommerce.entities.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
