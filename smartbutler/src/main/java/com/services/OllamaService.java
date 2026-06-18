package com.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ai.OllamaRequest;
import com.ai.OllamaResponse;

@Service
public class OllamaService {
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
