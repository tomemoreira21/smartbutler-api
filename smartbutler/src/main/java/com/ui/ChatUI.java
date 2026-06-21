package com.ui;

import java.util.Scanner;

import com.clients.ChatClient;

public class ChatUI {
    private final ChatClient chat;

    public ChatUI(ChatClient chat) {
        this.chat = chat;
    }

    public void iniciar(Scanner sc, Integer utilizadorId) {
        System.out.println("\nYou can start chatting.");
        System.out.println("Type 'exit' to leave.\n");
        
        while (true) {
            System.out.print("YOU: ");
            String mensagem = sc.nextLine();

            if (mensagem.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                String resposta = chat.enviar(utilizadorId, mensagem);

                System.out.println("BOT: " + resposta + "\n");

            } catch (Exception e) {
                System.out.println("BOT: Sorry, something went wrong.\n");
            }
        }
    }

}
