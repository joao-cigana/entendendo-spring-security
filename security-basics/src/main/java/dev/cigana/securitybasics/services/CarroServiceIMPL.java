package dev.cigana.securitybasics.services;

import dev.cigana.securitybasics.domain.Carro;
import dev.cigana.securitybasics.domain.CarroFormDTO;
import dev.cigana.securitybasics.domain.CarroResponseDTO;
import dev.cigana.securitybasics.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarroServiceIMPL implements CarroService{

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public CarroResponseDTO create(CarroFormDTO carroFormDTO) {
        return new CarroResponseDTO(carroRepository.save(carroFormDTO.toCarro()));
    }

    @Override
    public CarroResponseDTO findById(String id) {
        return new CarroResponseDTO(carroRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado - id: " + id)));
    }

    @Override
    public Page<CarroResponseDTO> findAll(Pageable pageable) {
        return carroRepository.findAll(pageable).map(CarroResponseDTO::new);
    }

    @Override
    public void deleteById(String id) {
        if(!carroRepository.existsById(id)){
            throw new RuntimeException("Recurso não encontrado - id: " + id);
        }
        carroRepository.deleteById(id);
    }
}
