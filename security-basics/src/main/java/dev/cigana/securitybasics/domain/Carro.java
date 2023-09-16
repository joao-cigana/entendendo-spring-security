package dev.cigana.securitybasics.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "carros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carro {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "marca")
    private String marca;

}
