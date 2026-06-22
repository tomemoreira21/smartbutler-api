package com.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ai.AIService;
import com.ai.gemini.GeminiRequest;
import com.ai.gemini.GeminiResponse;

@Service
public class GeminiService implements AIService {
    private final RestClient restClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    public GeminiService() {
        this.restClient = RestClient.create("https://generativelanguage.googleapis.com");
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public String perguntar(String prompt) {
        GeminiRequest request =new GeminiRequest(prompt);

        GeminiResponse response = restClient.post()
                                        .uri(
                                            "/v1beta/models/gemini-2.5-flash:generateContent?key="
                                            + apiKey
                                        )
                                        .body(request)
                                        .retrieve()
                                        .body(GeminiResponse.class);
        return response
            .getCandidates()
            .get(0)
            .getContent()
            .getParts()
            .get(0)
            .getText();
    }

}
