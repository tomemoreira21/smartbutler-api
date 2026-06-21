package com.actions.individuals;

import org.springframework.stereotype.Service;

import com.actions.ChatAction;
import com.ai.dto.ChatIntentDTO;
import com.enums.AcaoChat;
import com.services.TransacaoService;

@Service
public class ConsultaGastosPeriodoAction implements ChatAction {
    private final TransacaoService service;

    public ConsultaGastosPeriodoAction(TransacaoService service) {
        this.service = service;
    }

    public TransacaoService getService() {
        return service;
    }

    public AcaoChat suporta() {
        return AcaoChat.GASTOS_PERIODO;
    }
    
    public Object executar(Integer utilizadorId, ChatIntentDTO intent) {
        return this.service.gastoEntreDatas(utilizadorId, intent.getDataInicio(), intent.getDataFim());
    }
    
}
