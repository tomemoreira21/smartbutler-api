package com.clients;

import org.springframework.web.client.RestTemplate;

import com.dto.CriarUtilizadorDTO;
import com.entities.Utilizador;

public class UtilizadorClient {
    private final RestTemplate api = new RestTemplate();

    private final String BASE = "http://localhost:8080";

    public Utilizador login(String email) {
        return api.getForObject(BASE + "/utilizadores/email/" + email,
                Utilizador.class);
    }

    public Utilizador criar(String nome, String email) {
        CriarUtilizadorDTO dto = new CriarUtilizadorDTO();

        dto.setNome(nome);
        dto.setEmail(email);

        return api.postForObject(
                BASE + "/utilizadores",
                dto,
                Utilizador.class);
    }
}
