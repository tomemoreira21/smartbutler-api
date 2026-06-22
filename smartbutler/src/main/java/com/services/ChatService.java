package com.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.actions.ChatAction;
import com.ai.AIService;
import com.ai.dto.ChatIntentDTO;
import com.ai.dto.ChatResponseDTO;
import com.enums.AcaoChat;

import tools.jackson.databind.ObjectMapper;

@Service
public class ChatService {
    private final PromptService promptService;
    private final AIService aiService;
    private final ObjectMapper objectMapper; // conversão de JSON -> objetos Java
    
    private Map<AcaoChat, ChatAction> actions;

    public ChatService(PromptService promptService, AIService service, ObjectMapper objectMapper, List<ChatAction> actions) {
        this.promptService = promptService;
        this.aiService = service;
        this.objectMapper = objectMapper;
        
        this.actions = new HashMap<>();

        for (ChatAction acao : actions) {
            this.actions.put(acao.suporta(), acao);
        } 
    }

    public AIService getAIService() {
        return aiService;
    }

    public PromptService getPromptService() {
        return promptService;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public ChatIntentDTO interpretar(String message) {
        String template = promptService.loadPrompt("finance-intent.txt");
        String prompt = template.formatted(message);

        System.out.print("Using " + this.aiService + "\n");

        String resposta = aiService.perguntar(prompt);

        try {
            return objectMapper.readValue(resposta, 
                        ChatIntentDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao interpretar a resposta do Ollama: " + resposta, e);
        }
    }

    private String gerarResposta(String mensagemUser, Object dados) {
        try {
            String template = promptService.loadPrompt("transaction-summary.txt");
            String jsonDados = objectMapper.writeValueAsString(dados);

            String prompt = template.formatted(mensagemUser,jsonDados);
            return this.aiService.perguntar(prompt);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar a resposta", e);
        }
    }

    private String gerarConversa(String message) {
        String template = promptService.loadPrompt("general-chat.txt");

        return this.aiService.perguntar(template.formatted(message));
    }

    public ChatResponseDTO processar(Integer utilizadorId, String message) {
        ChatIntentDTO intent = interpretar(message);

        if (intent.getAcao() == AcaoChat.CONVERSA_NORMAL) 
            return new ChatResponseDTO(gerarConversa(message));

        ChatAction action = this.actions.get(intent.getAcao());

        if (action == null) {
            throw new RuntimeException("Unsupported action");
        }   

        Object dados = action.executar(utilizadorId, intent);

        String resposta = gerarResposta(message, dados);

        System.out.println("Mensagem: " + message);

        System.out.println("Intent: " + intent);

        System.out.println("ACAO = " + intent.getAcao());

        System.out.println(
            "DADOS = "
            + objectMapper.writeValueAsString(dados)
        );

        System.out.println("Resposta final: " + resposta);

        return new ChatResponseDTO(resposta);
    }

}