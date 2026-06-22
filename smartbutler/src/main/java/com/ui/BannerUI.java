package com.ui;

public class BannerUI {
    private static final String RESET  = "\u001B[0m";
    private static final String BOLD   = "\u001B[1m";
    private static final String DIM    = "\u001B[2m";
    private static final String CYAN   = "\u001B[36m";
    private static final String BLUE   = "\u001B[34m";
    private static final String WHITE  = "\u001B[97m";

    public static void printBanner() {
        System.out.println();
        System.out.println(CYAN + BOLD + "  ____  __  __    _    ____ _____   ____  _   _ _____ _     _____ ____  " + RESET);
        System.out.println(CYAN + BOLD + " / ___||  \\/  |  / \\  |  _ \\_ _| | __ )| | | |_   _| |   | ____|  _ \\ " + RESET);
        System.out.println(CYAN +        " \\___ \\| |\\/| | / _ \\ | |_) || |   |  _ \\| | | | | | | |   |  _| | |_) |" + RESET);
        System.out.println(BLUE +        "  ___) | |  | |/ ___ \\|  _ < | |   | |_) | |_| | | | | |___| |___|  _ < " + RESET);
        System.out.println(BLUE + BOLD + " |____/|_|  |_/_/   \\_\\_| \\_\\___|   |____/ \\___/  |_| |_____|_____|_| \\_\\" + RESET);
        System.out.println();
        System.out.println(DIM   + "  ══════════════════════════════════════════════════════════════════════" + RESET);
        System.out.println(WHITE + "  ✦  AI-Powered Personal Assistant" + RESET + DIM + "          :: SmartButler v1.0" + RESET);
        System.out.println(DIM   + "  ══════════════════════════════════════════════════════════════════════" + RESET);
        System.out.println();
    }
}
