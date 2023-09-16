package dev.cigana.securitybasics.domain;

import lombok.Getter;

public record CarroResponseDTO(

        String id,
        String nome,
        String marca) {

    public CarroResponseDTO(Carro carro){
        this(carro.getId(), carro.getNome(), carro.getMarca());
    }

}
