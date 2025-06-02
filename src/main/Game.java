package main;

import java.util.Scanner;

public class Game {

    public Game() {
        System.out.println("Initializing game...");
    }

    public void run() {
        System.out.println("Running game...");

    }

    public String getCommandInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("> Enter command: ");
        String input = scanner.nextLine();
        return input;
    }
    //SingleTon de game
    private static Game INSTANCE;
    public static Game getGameInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Game();
        }
        return INSTANCE;
    }
}