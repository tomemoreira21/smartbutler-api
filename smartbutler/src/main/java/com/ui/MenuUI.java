package com.ui;

import java.util.Scanner;
import com.clients.UtilizadorClient;
import com.clients.ChatClient;
import com.entities.Utilizador;

public class MenuUI {
    private static final String RESET  = "\u001B[0m";
    private static final String BOLD   = "\u001B[1m";
    private static final String DIM    = "\u001B[2m";
    private static final String CYAN   = "\u001B[36m";
    private static final String GREEN  = "\u001B[32m";
    private static final String RED    = "\u001B[31m";
    private static final String WHITE  = "\u001B[97m";

    private final Scanner sc;
    private final LoginUI loginUI;
    private final CreateAccountUI createAccountUI;
    private final ChatUI chatUI;

    public MenuUI(Scanner sc, UtilizadorClient utilizadorClient, ChatClient chatClient) {
        this.sc = sc;
        this.loginUI = new LoginUI(utilizadorClient);
        this.createAccountUI = new CreateAccountUI(utilizadorClient);
        this.chatUI = new ChatUI(chatClient);
    }

    public void run() {
        BannerUI.printBanner();

        while (true) {
            printMenu();
            String opcao = sc.nextLine().trim();

            switch (opcao) {
                case "1" -> handleLogin();
                case "2" -> handleCreateAccount();
                case "Q", "q" -> {
                    System.out.println();
                    System.out.println(DIM + "  Goodbye. ✦" + RESET);
                    System.out.println();
                    return;
                }
                default -> System.out.println(RED + "  ✖  Invalid option. Try 1, 2 or Q." + RESET + "\n");
            }
        }
    }

    private void printMenu() {
        System.out.println("  ┌─────────────────────────────────────────┐");
        System.out.println("  │        " + WHITE + BOLD + "What would you like to do?" + RESET + "       │");
        System.out.println("  │                                         │");
        System.out.println("  │    " + CYAN + "[1]" + RESET + "  Login                           │");
        System.out.println("  │    " + CYAN + "[2]" + RESET + "  Create Account                  │");
        System.out.println("  │    " + DIM  + "[Q]  Quit" + RESET + "                            │");
        System.out.println("  └─────────────────────────────────────────┘");
        System.out.println();
        System.out.print(CYAN + "  ▶ " + RESET);
    }

    private void handleLogin() {
        Utilizador user = loginUI.login(sc);
        if (user != null) {
            System.out.println(GREEN + "  ✔  Logged in successfully." + RESET);
            System.out.println(DIM   + "  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
            System.out.println();
            System.out.println("  Welcome back, " + BOLD + WHITE + user.getNome() + RESET + " " + CYAN + "✦" + RESET);
            chatUI.iniciar(sc, user.getId());
            BannerUI.printBanner();
        }
    }

    private void handleCreateAccount() {
        Utilizador user = createAccountUI.criarConta(sc);
        if (user != null) {
            System.out.println(GREEN + "  ✔  Account created successfully." + RESET);
            System.out.println(DIM   + "  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + RESET);
            System.out.println();
            System.out.println("  Hello, " + BOLD + WHITE + user.getNome() + RESET + " " + CYAN + "✦" + RESET);
            chatUI.iniciar(sc, user.getId());
            BannerUI.printBanner();
        }
    }
}