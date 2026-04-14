package br.com.trabalho.faculdade.backend.Backend.dto.response;

public record PedidoResponseDto(
        Long id,
        Long clienteId,
        Long produtoId,
        Integer quantidade
) {
}
