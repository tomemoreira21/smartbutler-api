package com.services;

import org.springframework.stereotype.Service;

import com.ai.dto.ChatIntentDTO;
import com.ai.dto.ChatResponseDTO;

import tools.jackson.databind.ObjectMapper;

@Service
public class ChatService {
    private final PromptService promptService;
    private final OllamaService ollamaService;
    private final ObjectMapper objectMapper; // conversão de JSON -> objetos Java
    private final TransacaoService transacaoService;
    private final SaldoService saldoService;

    public ChatService(PromptService promptService, OllamaService ollamaService, ObjectMapper objectMapper, TransacaoService transacaoService, SaldoService saldoService) {
        this.promptService = promptService;
        this.ollamaService = ollamaService;
        this.objectMapper = objectMapper;
        this.transacaoService = transacaoService;
        this.saldoService = saldoService;
    }

    public OllamaService getOllamaService() {
        return ollamaService;
    }

    public PromptService getPromptService() {
        return promptService;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public TransacaoService getTransacaoService() {
        return transacaoService;
    }

    public SaldoService getSaldoService() {
        return saldoService;
    }

    public ChatIntentDTO interpretar(String message) {
        String template = promptService.loadPrompt("finance-intent.txt");
        String prompt = template.formatted(message);

        String resposta = ollamaService.perguntar(prompt);

        try {
            return objectMapper.readValue(resposta, 
                        ChatIntentDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao interpretar a resposta do Ollama: " + resposta, e);
        }
    }

    public ChatResponseDTO processar(Integer utilizadorId, String message) {
        //ChatIntentDTO intent = interpretar(message);





    }

}
