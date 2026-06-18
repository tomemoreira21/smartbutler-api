package com;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ai.dto.ChatIntentDTO;
import com.enums.AcaoChat;
import com.enums.TipoTransacao;
import com.services.ChatService;

@SpringBootTest
public class ChatServiceTests {

    @Autowired
    private ChatService service;

    @Test
    void interpretarDespesa() {

        ChatIntentDTO dto =
                service.interpretar(
                        "Gastei 20 euros num restaurante"
                );

        assertThat(dto.getAcao())
                .isEqualTo(
                        AcaoChat.CRIAR_TRANSACAO
                );

        assertThat(dto.getTipo())
                .isEqualTo(
                        TipoTransacao.DESPESA
                );

        assertThat(dto.getValor())
                .isEqualByComparingTo(
                        "20"
                );
    }
}