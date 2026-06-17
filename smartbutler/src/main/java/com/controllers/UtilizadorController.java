package com.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CriarUtilizadorDTO;
import com.entities.Utilizador;
import com.services.UtilizadorService;

@RestController
@RequestMapping("/utilizadores")
public class UtilizadorController {
    private final UtilizadorService service;

    public UtilizadorController(UtilizadorService service) {
        this.service = service;
    }

    @PostMapping
    public Utilizador criar(@RequestBody CriarUtilizadorDTO dto) {
        return service.criar(dto);
    }
}
