package dev.cigana.securitybasics.services.interfaces;

import dev.cigana.securitybasics.domain.carro.CarroFormDTO;
import dev.cigana.securitybasics.domain.carro.CarroResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarroService {

    CarroResponseDTO create (CarroFormDTO carroFormDTO);
    CarroResponseDTO findById(String id);

    Page<CarroResponseDTO> findAll(Pageable pageable);

    void deleteById(String id);

}
