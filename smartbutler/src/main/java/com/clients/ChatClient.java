package com.clients;

import org.springframework.web.client.RestTemplate;

import com.ai.dto.ChatRequestDTO;
import com.ai.dto.ChatResponseDTO;

public class ChatClient {
    private final RestTemplate api = new RestTemplate();
    
    private final String BASE = "http://localhost:8080";

    public String enviar(Integer utilizadorId, String mensagem) {
        ChatRequestDTO dto = new ChatRequestDTO(utilizadorId, 
                                                mensagem);
        
        ChatResponseDTO resposta = api.postForObject(BASE + "/chat", 
                                                    dto, ChatResponseDTO.class);

        return resposta.getResposta();
    }
}
