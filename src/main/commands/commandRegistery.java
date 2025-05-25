package main.commands;

import main.Game;
import main.commands.commands.map;
import main.commands.map; // Ensure this import matches your actual package structure

public class commandRegistery {

    public static void registerCommands() {
        System.out.println("Commands registered successfully.");
    }
    public void commandChoose() {
        Game game = new Game();
        String command = game.getCommandInput();
        switch (command.toLowerCase()) {
            case "map" -> {
                map mapInstance = new map();
                mapInstance.displayMap();
            }
            case "help" -> {
                System.out.println("Available commands: map, help");
            }
            default -> {
                System.out.println("Unknown command: " + command);
            }
        }
    }
    

    
    
}
