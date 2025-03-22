package dev.leandro.ecommerce.controller.dto;

public record PaginationResponseDto(Integer page,
                                    Integer pageSize,
                                    Long totalElements,
                                    Integer totalPages) {
}
