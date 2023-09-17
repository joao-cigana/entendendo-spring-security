package dev.cigana.securitybasics.domain.carro;

import jakarta.validation.constraints.NotBlank;

public record CarroFormDTO(
        @NotBlank
        String nome,

        @NotBlank
        String marca) {

    public Carro toCarro(){
        return Carro.builder()
                .nome(this.nome)
                .marca(this.marca)
                .build();
    }

}
