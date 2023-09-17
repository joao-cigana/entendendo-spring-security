package dev.cigana.securitybasics.repositories;

import dev.cigana.securitybasics.domain.carro.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, String> {



}
