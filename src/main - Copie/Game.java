package main;

import java.util.Scanner;

public class Game {

    private java.util.Scanner scanner;

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
        System.out.println("test");
        return input;
    }

}