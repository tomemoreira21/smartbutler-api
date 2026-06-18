package com.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.dto.ChatRequestDTO;
import com.ai.dto.ChatResponseDTO;
import com.services.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    public ChatService getService() {
        return this.service;
    }

    @PostMapping
    public ChatResponseDTO conversar(@RequestBody ChatRequestDTO dto) {

        System.out.println("DTO = " + dto.getUtilizadorId());
        System.out.println("MSG = " + dto.getMessage());

        return service.processar(dto.getUtilizadorId(), dto.getMessage());
    }

}
