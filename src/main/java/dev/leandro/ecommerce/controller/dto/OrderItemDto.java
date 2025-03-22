package dev.leandro.ecommerce.controller.dto;

public record OrderItemDto(Integer quantity,
                           Long productId) {
}
