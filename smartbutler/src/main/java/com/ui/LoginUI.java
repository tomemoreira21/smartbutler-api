package com.ui;

import java.util.Scanner;

import com.clients.UtilizadorClient;
import com.entities.Utilizador;

public class LoginUI {
    private final UtilizadorClient users;

    public LoginUI(UtilizadorClient users) {
        this.users = users;
    }

    public Utilizador login(Scanner sc) {
        while (true) {

            System.out.print("Email: ");
            String email = sc.nextLine();

            try {
                return this.users.login(email);

            } catch(Exception e) {
                System.out.println("User not found!");
            }
        }
    }
}
