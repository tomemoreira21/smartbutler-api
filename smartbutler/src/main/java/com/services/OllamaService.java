package com.services;

import org.springframework.beans.factory.annotation.Value;
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
    private final String model;

    public OllamaService(@Value("${ollama.url}")String url, @Value("${ollama.model}") String model) {
        this.restClient = RestClient.create(url);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    
    public String perguntar(String prompt) {
        OllamaRequest request = new OllamaRequest(model, prompt, false);
        OllamaResponse response = restClient.post()
                                    .uri("/api/generate")
                                    .body(request)
                                    .retrieve()
                                    .body(OllamaResponse.class);

        return response != null ? response.getResponse() : null;
    }
}
