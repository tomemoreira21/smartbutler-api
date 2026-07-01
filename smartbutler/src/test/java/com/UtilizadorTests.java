package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.dto.CriarUtilizadorDTO;
import com.entities.Utilizador;
import com.exceptions.EmailJaExisteException;
import com.repositories.UtilizadorRepository;
import com.services.UtilizadorService;

@SpringBootTest
@ActiveProfiles("test")
public class UtilizadorTests {

    @Autowired
    private UtilizadorRepository repository;

    @Autowired
    private UtilizadorService service;


    @Test
    void criarUtilizador() {

        Utilizador u = new Utilizador(
                "Joao",
                "joao@gmail.com"
        );

        Utilizador guardado = repository.save(u);

        assertThat(guardado.getId()).isNotNull();
    }

    
    @Test
    void criarUtilizadorDuplicado() throws EmailJaExisteException {

        // cria o utilizador normalmente
        assertThatCode(() -> service.criar(
            new CriarUtilizadorDTO(
                "Joao", 
                "joao@gmail.com")
        )).doesNotThrowAnyException();

        // email duplicado dá a exceção
        assertThatThrownBy(() -> service.criar(new CriarUtilizadorDTO("Joao", "joao@gmail.com")))
                    .isInstanceOf(EmailJaExisteException.class);
    }


    @Test
    void loginUtilizadorInexistente() {
        assertEquals(service.procurarPorEmail("fake@gmail.com"), null);

    }

}