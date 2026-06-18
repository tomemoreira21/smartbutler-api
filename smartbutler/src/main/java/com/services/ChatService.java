package com.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ai.dto.ChatIntentDTO;
import com.ai.dto.ChatResponseDTO;
import com.dto.CriarTransacaoDTO;
import com.entities.Transacao;

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

    private String gerarResposta(String mensagemUser, Object dados) {
        try {
            String template = promptService.loadPrompt("transaction-summary.txt");
            String jsonDados = objectMapper.writeValueAsString(dados);

            String prompt = template.formatted(mensagemUser,jsonDados);
            return this.ollamaService.perguntar(prompt);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar a resposta", e);
        }
    }

    public ChatResponseDTO processar(Integer utilizadorId, String message) {
        ChatIntentDTO intent = interpretar(message);
        Object dados;

        switch (intent.getAcao()) {
            case CRIAR_TRANSACAO:
                CriarTransacaoDTO dto = new CriarTransacaoDTO();
                
                dto.setUtilizadorId(utilizadorId);
                dto.setCategoria(intent.getCategoria());
                dto.setValor(intent.getValor());
                dto.setTipo(intent.getTipo());
                dto.setDescricao(intent.getDescricao());

                Transacao transacao = this.transacaoService.criar(dto);
                dados = transacao;
                break;  

            case CONSULTAR_TODAS_TRANSACOES:
                List<Transacao> transacoes = transacaoService.listarTransacoesUtilizador(utilizadorId);

                dados = Map.of(
                    "transactionCount",
                    transacoes.size(),
                    "transactions",
                    transacoes
                );
    
                break;
            
            case CONSULTAR_SALDO:
                dados = this.saldoService.saldo(utilizadorId);
                break;

            case ULTIMAS_TRANSACOES:
                dados = this.transacaoService.ultimasTransacoes(utilizadorId);
                break;

            case GASTOS_POR_CATEGORIA:
                dados = this.transacaoService.gastosCategoria(utilizadorId);
                break;

            case GASTOS_PERIODO:
                dados = this.transacaoService.gastoEntreDatas(utilizadorId, intent.getDataInicio(), intent.getDataFim());
                break;

            default:
                throw new RuntimeException("Ação não suportada");
        }

        String resposta = gerarResposta(message, dados);

        System.out.println("Mensagem: " + message);

        System.out.println("Intent: " + intent);

        System.out.println("Dados: " + dados);

        System.out.println("Resposta final: " + resposta);

        return new ChatResponseDTO(resposta);
    }

}
