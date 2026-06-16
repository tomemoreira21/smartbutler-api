package com;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entities.Utilizador;
import com.repositories.UtilizadorRepository;



@SpringBootTest
public class UtilizadorTests {

    @Autowired
    private UtilizadorRepository repository;


    @Test
    void criarUtilizador() {

        Utilizador u = new Utilizador(
                "Joao",
                "joao@gmail.com"
        );

        Utilizador guardado = repository.save(u);

        assertThat(guardado.getId()).isNotNull();
    }
}