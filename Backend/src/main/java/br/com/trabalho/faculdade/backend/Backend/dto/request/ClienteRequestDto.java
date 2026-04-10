package br.com.trabalho.faculdade.backend.Backend.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDto(
        @NotBlank
        String nome
) {
}
