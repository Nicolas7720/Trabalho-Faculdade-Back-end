package br.com.trabalho.faculdade.backend.Backend.dto.request;

import jakarta.validation.constraints.NotNull;

public record PedidoRequestDto(
        @NotNull
        Long clienteId,
        @NotNull
        Long produtoId,
        @NotNull
        Integer quantidade
) {
}
