package com.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.repositories.TransacaoRepository;

@Service
public class SaldoService {
    private final TransacaoRepository repository;

    public SaldoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public TransacaoRepository getRepository() {
        return repository;
    }

    public BigDecimal saldo(Integer id) {
        BigDecimal receitas = repository.totalReceitas(id);
        BigDecimal gastos = repository.totalGasto(id);

        if (receitas == null) {
            receitas = BigDecimal.ZERO;
        }

        if (gastos == null) {
            gastos = BigDecimal.ZERO;
        }

        return receitas.subtract(gastos);
    }
    
}
