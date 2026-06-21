package com.actions.individuals;

import org.springframework.stereotype.Service;

import com.actions.ChatAction;
import com.ai.dto.ChatIntentDTO;
import com.enums.AcaoChat;
import com.services.TransacaoService;

@Service
public class ConsultaGastosCategoriaAction implements ChatAction {
    private final TransacaoService service;

    public ConsultaGastosCategoriaAction(TransacaoService service) {
        this.service = service;
    }

    public TransacaoService getService() {
        return service;
    }

    public AcaoChat suporta() {
        return AcaoChat.GASTOS_POR_CATEGORIA;
    }

    public Object executar(Integer utilizadorId, ChatIntentDTO intent) {
        return this.service.gastosCategoria(utilizadorId);
    }
}
