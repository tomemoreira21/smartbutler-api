package com.ui;

import java.util.Scanner;

import com.clients.ChatClient;

public class ChatUI {
    private static final String RESET  = "\u001B[0m";
    private static final String BOLD   = "\u001B[1m";
    private static final String DIM    = "\u001B[2m";
    private static final String CYAN   = "\u001B[36m";
    private static final String RED    = "\u001B[31m";
    private static final String WHITE  = "\u001B[97m";

    private final ChatClient chat;

    public ChatUI(ChatClient chat) {
        this.chat = chat;
    }

    public void iniciar(Scanner sc, Integer utilizadorId) {
        System.out.println(DIM + "  Ask me anything. Type 'exit' to leave." + RESET);
        System.out.println();

        while (true) {
            System.out.print("  " + BOLD + WHITE + "YOU" + RESET + "  " + CYAN + "▸" + RESET + "  ");
            String mensagem = sc.nextLine();

            if (mensagem.equalsIgnoreCase("exit")) {
                System.out.println();
                System.out.println(DIM + "  Session ended. ✦" + RESET);
                System.out.println();
                break;
            }

            try {
                String resposta = chat.enviar(utilizadorId, mensagem);
                System.out.println("  " + CYAN + BOLD + "BOT" + RESET + "  " + CYAN + "✦" + RESET + "  " + resposta);
            } catch (Exception e) {
                System.out.println("  " + RED + "BOT  ✖  Sorry, something went wrong." + RESET);
            }

            System.out.println();
        }
    }

}
