package dev.cigana.securitybasics.controller;

import dev.cigana.securitybasics.domain.CarroFormDTO;
import dev.cigana.securitybasics.domain.CarroResponseDTO;
import dev.cigana.securitybasics.services.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<CarroResponseDTO> createCarro(@RequestBody @Valid CarroFormDTO formDTO){
        CarroResponseDTO carro = carroService.create(formDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carro.id())
                .toUri();
        return ResponseEntity.created(uri).body(carro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(carroService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<CarroResponseDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(carroService.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id){
        carroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
