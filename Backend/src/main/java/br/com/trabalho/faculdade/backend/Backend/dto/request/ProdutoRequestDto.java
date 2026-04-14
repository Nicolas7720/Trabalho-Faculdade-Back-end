package br.com.trabalho.faculdade.backend.Backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequestDto(
        @NotBlank
        String nome,
        @NotNull
        BigDecimal preco,
        @NotNull
        Boolean estoque
) {
}
