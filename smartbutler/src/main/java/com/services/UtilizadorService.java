package com.services;

import org.springframework.stereotype.Service;

import com.dto.CriarUtilizadorDTO;
import com.entities.Utilizador;
import com.repositories.UtilizadorRepository;

@Service
public class UtilizadorService {
    private final UtilizadorRepository repository;

    public UtilizadorService(UtilizadorRepository repository) {
        this.repository = repository;
    }

    public UtilizadorRepository getRepository() {
        return repository;
    }

    public Utilizador criar(CriarUtilizadorDTO dto) {
        Utilizador user = new Utilizador(
            dto.getNome(),
            dto.getEmail()
        );

        return repository.save(user);
    }
    
    
}
