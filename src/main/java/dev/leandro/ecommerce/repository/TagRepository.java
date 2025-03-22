package dev.leandro.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.leandro.ecommerce.entities.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
