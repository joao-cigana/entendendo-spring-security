package dev.cigana.securitybasics.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank
        String username,

        @NotBlank
        String password) {
}
