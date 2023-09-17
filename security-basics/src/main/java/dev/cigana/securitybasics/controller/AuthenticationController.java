package dev.cigana.securitybasics.controller;

import dev.cigana.securitybasics.domain.usuario.JWTDTO;
import dev.cigana.securitybasics.domain.usuario.Usuario;
import dev.cigana.securitybasics.domain.usuario.UsuarioDTO;
import dev.cigana.securitybasics.services.JWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTService jwtService;

    @PostMapping
    public ResponseEntity<JWTDTO> efetuarLogin(@RequestBody @Valid UsuarioDTO dto){
        var token = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok(new JWTDTO(jwtService.generateToken((Usuario) authentication.getPrincipal())));
    }

}
