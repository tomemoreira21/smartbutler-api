package com.services;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

@Service
public class PromptService {
      public String loadPrompt(String fileName) {

        try (
            InputStream input =
                getClass()
                    .getClassLoader()
                    .getResourceAsStream(
                        "prompts/" + fileName
                    )
        ) {

            return new String(
                input.readAllBytes(),
                StandardCharsets.UTF_8
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
