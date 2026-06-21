package com.actions.individuals;

import org.springframework.stereotype.Service;

import com.actions.ChatAction;
import com.ai.dto.ChatIntentDTO;
import com.enums.AcaoChat;
import com.services.TransacaoService;

@Service
public class ConsultaUtilmasTransacoesAction implements ChatAction {
    private final TransacaoService service;

    public ConsultaUtilmasTransacoesAction(TransacaoService service) {
        this.service = service;
    }

    public TransacaoService getService() {
        return service;
    }

    public AcaoChat suporta() {
        return AcaoChat.ULTIMAS_TRANSACOES;
    }
    
    public Object executar(Integer utilizadorId, ChatIntentDTO intent) {
        return this.service.ultimasTransacoes(utilizadorId);
    }
    
}
