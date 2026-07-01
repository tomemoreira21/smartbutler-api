package com;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ai.dto.ChatIntentDTO;
import com.enums.AcaoChat;
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
                        "DESPESA");

        assertThat(dto.getValor())
                .isEqualByComparingTo(
                        "20"
                );
    }

    @Test
    void interpretarReceita() {

        ChatIntentDTO dto =
                service.interpretar(
                        "Recebi 1500 euros do meu salário"
                );

        assertThat(dto.getAcao())
                .isEqualTo(AcaoChat.CRIAR_TRANSACAO);

        assertThat(dto.getTipo())
                .isEqualTo("RECEITA");

        assertThat(dto.getValor())
                .isEqualByComparingTo("1500");
    }


    @Test
    void interpretarConsultaTodasTransacoes() {

        ChatIntentDTO dto =
                service.interpretar(
                        "Mostra-me todas as minhas transações"
                );

        assertThat(dto.getAcao())
                .isEqualTo(AcaoChat.CONSULTAR_TODAS_TRANSACOES);
    }


    @Test
    void interpretarConsultarSaldo() {

        ChatIntentDTO dto =
                service.interpretar(
                        "Qual é o meu saldo atual?"
                );

        assertThat(dto.getAcao())
                .isEqualTo(AcaoChat.CONSULTAR_SALDO);
    }


    @Test
    void interpretarUltimasTransacoes() {

        ChatIntentDTO dto =
                service.interpretar(
                        "Quais foram os meus últimos movimentos?"
                );

        assertThat(dto.getAcao())
                .isEqualTo(AcaoChat.ULTIMAS_TRANSACOES);
    }

    @Test
    void interpretarConversaComum() {
        ChatIntentDTO dto = service.interpretar("Olá, tudo bem?");

        assertThat(dto.getAcao()).isEqualTo(AcaoChat.CONVERSA_NORMAL);
    }


}