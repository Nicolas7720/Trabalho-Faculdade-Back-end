package br.com.trabalho.faculdade.backend.Backend.dto.response;

public record PedidoResponseDto(
        Long id,
        Long pedidoId,
        Long produtoId,
        Integer quantidade
) {
}
