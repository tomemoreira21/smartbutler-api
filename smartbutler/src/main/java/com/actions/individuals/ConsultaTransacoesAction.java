package com.actions.individuals;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.actions.ChatAction;
import com.ai.dto.ChatIntentDTO;
import com.entities.Transacao;
import com.enums.AcaoChat;
import com.services.TransacaoService;

@Service
public class ConsultaTransacoesAction implements ChatAction {
    private final TransacaoService service;

    public ConsultaTransacoesAction(TransacaoService service) {
        this.service = service;
    }

    public TransacaoService getService() {
        return service;
    }

    public AcaoChat suporta() {
        return AcaoChat.CONSULTAR_TODAS_TRANSACOES;
    }

    public Object executar(Integer utilizadorId, ChatIntentDTO intent) {
         List<Transacao> transacoes = this.service.listarTransacoesUtilizador(utilizadorId);

        return Map.of(
                "transactionCount",
                transacoes.size(),
                "transactions",
                transacoes
                );
    }
    
}
