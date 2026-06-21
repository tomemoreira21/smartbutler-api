package com.actions.individuals;

import org.springframework.stereotype.Service;

import com.actions.ChatAction;
import com.ai.dto.ChatIntentDTO;
import com.dto.CriarTransacaoDTO;
import com.enums.AcaoChat;
import com.services.TransacaoService;

@Service
public class CriarTransicaoAction implements ChatAction {
    private final TransacaoService service;

    public CriarTransicaoAction(TransacaoService service) {
        this.service = service;
    }

    public TransacaoService getService() {
        return service;
    }

    public AcaoChat suporta() {
        return AcaoChat.CRIAR_TRANSACAO;
    }

    public Object executar(Integer utilizadorId, ChatIntentDTO intent) {
        CriarTransacaoDTO dto = new CriarTransacaoDTO(utilizadorId, 
                                                      intent.getCategoria(),
                                                      intent.getValor(),
                                                      intent.getDescricao(),
                                                      intent.getTipo());


        return this.service.criar(dto);
    }
            
        


}
