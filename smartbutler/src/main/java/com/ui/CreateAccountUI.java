package com.ui;

import java.util.Scanner;

import com.clients.UtilizadorClient;
import com.entities.Utilizador;

public class CreateAccountUI {
    private final UtilizadorClient users;

    public CreateAccountUI(UtilizadorClient users) {
        this.users = users;
    }

    public Utilizador criarConta(Scanner sc) {
        while (true) {
            System.out.print("Name: ");
            String nome = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            try {
                Utilizador user = users.criar(nome, email);
                System.out.println("Account created successfully.");

                return user;

            } catch (Exception e) {
                  System.out.println("Email already exists.");
            }
        }
    }
}
