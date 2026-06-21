package com.actions.individuals;

import org.springframework.stereotype.Service;

import com.actions.ChatAction;
import com.ai.dto.ChatIntentDTO;
import com.enums.AcaoChat;
import com.services.SaldoService;

@Service
public class ConsultaSaldoAction implements ChatAction {
    private final SaldoService service;

    public ConsultaSaldoAction(SaldoService service) {
        this.service = service;
    }

    public SaldoService getService() {
        return service;
    }

    public AcaoChat suporta() {
        return AcaoChat.CONSULTAR_SALDO;
    }

    public Object executar(Integer utilizadorId, ChatIntentDTO intent) {
        return this.service.saldo(utilizadorId);
    }


}