package dev.leandro.ecommerce.controller.dto;

import dev.leandro.ecommerce.entities.TagEntity;

public record TagResponseDto(Long tagId,
                             String name) {

    public static TagResponseDto fromEntity(TagEntity entity) {
        return new TagResponseDto(
                entity.getTagId(),
                entity.getName()
        );
    }
}
