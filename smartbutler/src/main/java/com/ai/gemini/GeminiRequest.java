package com.ai.gemini;

import java.util.List;

public class GeminiRequest {
    private List<Content> contents;

    public GeminiRequest(String prompt) {
        this.contents = List.of(new Content(List.of(new Part(prompt))));
    }

    public List<Content> getContents() {
        return this.contents;
    }
}
