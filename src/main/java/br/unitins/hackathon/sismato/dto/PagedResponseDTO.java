package br.unitins.hackathon.sismato.dto;

import java.util.List;

public record PagedResponseDTO<T>(
        long count,
        long total,
        long currentPage,
        long totalPages,
        List<T> items
) {
    public static <T> PagedResponseDTO<T> toDTO(Long count, Long total, Long currentPage, Long totalPages, List<T> items) {
        return new PagedResponseDTO<>(count, total, currentPage, totalPages, items);
    }
}
