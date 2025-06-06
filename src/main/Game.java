package main;

import main.commands.Command;
import main.commands.CommandRegistery;
import main.player.Player;
import main.world.WorldMap;
import utils.Color;
import utils.StringStyling;
import utils.Style;

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
        System.out.println(StringStyling.StyleString("Initializing game...", Style.ITALIC, Color.GREEN));
        System.out.println(StringStyling.StyleString("Welcome to the game! Type “help” for the list of commands.", Style.BOLD, Color.WHITE));
        System.out.println(StringStyling.StyleString("BRRRRR! The dungeon door creaks open. You find yourself facing a storage room.You enter.", Style.BOLD, Color.WHITE));
        System.out.println(StringStyling.StyleString("A gust of wind whispers in your ear: \"Here lies the treasure of a queen once known for her wealth and grandeur, called Dagmar.", Style.BOLD, Color.WHITE));
        System.out.println(StringStyling.StyleString("Overnight, she disappeared, leaving behind all her riches. But be warned, you may not be alone in this dungeon...\"", Style.BOLD, Color.WHITE));
        System.out.println(StringStyling.StyleString("look closely, clues may be hidden in unlikely places", Style.BOLD, Color.WHITE));

            int count = 0;
        while (isRunning) {
            count++;
            if (count == 50) {
                System.out.println();
                System.out.println(StringStyling.StyleString("You hear a horrifying sound behind you", Style.NORMAL, Color.CYAN));
                System.out.println(StringStyling.StyleString("You look behind...", Style.NORMAL, Color.CYAN));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(StringStyling.StyleString("But nothing...", Style.NORMAL, Color.CYAN));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(StringStyling.StyleString("Is your mind playing tricks on you?", Style.NORMAL, Color.CYAN));
                System.out.println();
            }
            if (count == 75) {
                System.out.println();
                System.out.println(StringStyling.StyleString("The sound is really close now", Style.NORMAL, Color.YELLOW));
                System.out.println(StringStyling.StyleString("You feel a breath on your neck", Style.NORMAL, Color.YELLOW));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(StringStyling.StyleString("But once again nothing...", Style.NORMAL, Color.YELLOW));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(StringStyling.StyleString("Your mind is not playing tricks on you, you should get out...Now !", Style.NORMAL, Color.YELLOW));
                System.out.println();
            }
            if (count == 100) {
                System.out.println();
                System.out.println(StringStyling.StyleString("You hear a terrifying scream", Style.NORMAL, Color.RED));
                System.out.println(StringStyling.StyleString("The creature is running towards you", Style.NORMAL, Color.RED));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(StringStyling.StyleString("You close your fists, ready to fight.", Style.NORMAL, Color.RED));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(StringStyling.StyleString("But...it's no use trying to fight this...", Style.NORMAL, Color.RED));
                System.out.println(StringStyling.StyleString("Monster", Style.NORMAL, Color.RED));

                isRunning = false;
                System.out.println(StringStyling.StyleString("It cuts your head off !", Style.BOLD, Color.RED));

                System.out.println(StringStyling.StyleString("You died", Style.BOLD, Color.RED));
                Game.getGameInstance().setIsRunning(false);
            }


            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            Command command = registry.getCommand(input);

            if (input.startsWith("take ")) {
                System.out.println("Try using only \"take\"");
                continue;
            } else if (input.startsWith("inspect ")) {
                System.out.println("Try using only \"inspect\"");
                continue;
            }else if (input.startsWith("use ")) {
                System.out.println("Try using only \"use\"");
                continue;
            }else if (input.startsWith("say ")) {
                System.out.println("Try using only \"say\"");
                continue;
            }
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

                System.out.println();
                System.out.println(StringStyling.StyleString("You escaped, congrats !", Style.BOLD, Color.GREEN));
                System.out.println(StringStyling.StyleString("You have found the treasures, and became a powerful being ! ", Style.BOLD, Color.GREEN));
                System.out.println(StringStyling.StyleString("=========================", Style.BOLD, Color.GREEN));
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
