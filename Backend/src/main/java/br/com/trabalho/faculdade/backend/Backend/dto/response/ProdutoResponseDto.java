package br.com.trabalho.faculdade.backend.Backend.dto.response;

import java.math.BigDecimal;

public record ProdutoResponseDto(
        Long id,
        String nome,
        BigDecimal preco,
        Boolean estoque
) {
}
