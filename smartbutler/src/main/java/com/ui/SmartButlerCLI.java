package com.ui;

import java.util.Scanner;

import com.clients.ChatClient;
import com.clients.UtilizadorClient;
import com.entities.Utilizador;

public class SmartButlerCLI {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        UtilizadorClient users = new UtilizadorClient();
        ChatClient chat = new ChatClient();

        LoginUI loginUI = new LoginUI(users);
        CreateAccountUI createUI = new CreateAccountUI(users);
        ChatUI chatUI = new ChatUI(chat);

        System.out.println("SMARTBUTLER");

        System.out.println("1. Login");
        System.out.println("2. Create account");

        System.out.print("> ");

        Integer op = sc.nextInt();
        sc.nextLine();

        Utilizador user = (op == 1) ? loginUI.login(sc) : createUI.criarConta(sc);

        System.out.println("\nLogged in successfully.");
        System.out.println("Welcome " + user.getNome() + "!");

        chatUI.iniciar(sc, user.getId());

        sc.close();
    }
}
