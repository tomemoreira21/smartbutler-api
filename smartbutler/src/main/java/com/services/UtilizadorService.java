package com.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dto.CriarUtilizadorDTO;
import com.entities.Utilizador;
import com.exceptions.EmailJaExisteException;
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

    public Utilizador criar(CriarUtilizadorDTO dto) throws EmailJaExisteException {
        if (procurarPorEmail(dto.getEmail()) != null) {
            throw new EmailJaExisteException(dto.getEmail());
        }

        Utilizador user = new Utilizador(
            dto.getNome(),
            dto.getEmail()
        );

        return repository.save(user);
    }

    public Utilizador procurarPorEmail(String email) {
        Optional<Utilizador> user = this.repository.findByEmail(email);

        return user.isPresent() ? user.get().clone() : null;
    }
    
    
}
