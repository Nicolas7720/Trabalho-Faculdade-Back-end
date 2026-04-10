package br.com.trabalho.faculdade.backend.Backend.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PedidoRequestDto(
        @NotBlank
        Long clienteId,
        @NotBlank
        Long produtoId,
        @NotBlank
        Integer quantidade
) {
}
