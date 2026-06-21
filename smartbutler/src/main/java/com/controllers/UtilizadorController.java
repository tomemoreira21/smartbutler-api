package com.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CriarUtilizadorDTO;
import com.entities.Utilizador;
import com.exceptions.EmailJaExisteException;
import com.exceptions.UtilizadorInexistenteException;
import com.services.UtilizadorService;

@RestController
@RequestMapping("/utilizadores")
public class UtilizadorController {
    private final UtilizadorService service;

    public UtilizadorController(UtilizadorService service) {
        this.service = service;
    }

    @PostMapping
    public Utilizador criar(@RequestBody CriarUtilizadorDTO dto) throws EmailJaExisteException {
        return service.criar(dto);
    }

    @GetMapping("/email/{email}")
    public Utilizador login(@PathVariable String email) throws UtilizadorInexistenteException {
        Utilizador user = this.service.procurarPorEmail(email);

        if (user == null) 
                throw new UtilizadorInexistenteException(email);

        return user.clone();
    }
}
