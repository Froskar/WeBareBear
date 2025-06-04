package main;

import main.commands.Command;
import main.commands.CommandRegistery;
import main.player.Player;
import main.world.WorldMap;

import java.util.Scanner;

public class Game {

    private boolean isRunning;
    private final Player player;
    private final WorldMap worldMap;
    private final CommandRegistery registry;

    public Game() {
        this.isRunning = true;
        this.player = new Player("Hero");
        this.worldMap = WorldMap.getWorldInstance();
        this.registry = CommandRegistery.getCommandInstance();
    }

    public void setIsRunning(Boolean state){
        this.isRunning = state;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Initializing game...");
        System.out.println("Welcome to the game! Type “help” for the list of commands.");

        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            Command command = registry.getCommand(input);

            if (command != null) {
                String output = command.execute();
                if (output != null && !output.isEmpty()) {
                    System.out.println(output);
                }
            } else {
                System.out.println("Unknown command. Type “help” to see the commands available.");
            }

            // Optionnel : arrêt du jeu si la commande est "quit"
            if (input.equals("quit")) {
                isRunning = false;
                System.out.println("End of game.");
            }
            if (Player.getInstance().getPosition().getCol() == 0 && Player.getInstance().getPosition().getRow() == 2){
                isRunning = false;
                System.out.println("Vous avez terminé le jeu");
            }
        }
    }

    // Singleton de Game
    private static Game INSTANCE;

    public static Game getGameInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Game();
        }
        return INSTANCE;
    }
}
