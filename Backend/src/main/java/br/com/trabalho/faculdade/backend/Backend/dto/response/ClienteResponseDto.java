package br.com.trabalho.faculdade.backend.Backend.dto.response;

import java.time.LocalDateTime;

public record ClienteResponseDto(
        Long id,
        String nome,
        LocalDateTime clienteDesde
) {
}
