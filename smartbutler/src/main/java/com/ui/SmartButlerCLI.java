package com.ui;

import java.util.Scanner;

import com.clients.ChatClient;
import com.clients.UtilizadorClient;

public class SmartButlerCLI {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        MenuUI menu = new MenuUI(sc, new UtilizadorClient(), new ChatClient());
        menu.run();
        sc.close();
    }
}
