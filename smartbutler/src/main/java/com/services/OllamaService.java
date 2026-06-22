package com.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ai.AIService;
import com.ai.ollama.OllamaRequest;
import com.ai.ollama.OllamaResponse;

@Service
@Primary
public class OllamaService implements AIService {
    private final RestClient restClient;

    public OllamaService() {
        this.restClient = RestClient.create("http://localhost:11434");
    }
    
    public String perguntar(String prompt) {
        String model = "llama3.2";

        OllamaRequest request = new OllamaRequest(model, prompt, false);
        OllamaResponse response = restClient.post()
                                    .uri("/api/generate")
                                    .body(request)
                                    .retrieve()
                                    .body(OllamaResponse.class);

        return response.getResponse();
    }
}
