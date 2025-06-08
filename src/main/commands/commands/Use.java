package main.commands.commands;

import main.Game;
import main.commands.Command;
import main.items.*;
import main.player.Player;
import main.world.Location;
import main.world.WorldMap;

import java.util.Scanner;

public class Use extends Command {

    public Use(String name, String descr, boolean commandState) {
        super(name, descr,commandState);
    }

    @Override
    public String execute() {
        Player player = Player.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which item do you want to use? > ");
        String itemName = scanner.nextLine().trim();

        // Récupérer l'item
        Item item = player.getInventory().getItem(itemName);
        if (item == null) {
            return "You do not own this item.";
        }

        // Si c'est une Key, on déverrouille la bonne salle
        if (item instanceof Key key) {
            String targetLocationName = key.getLocationToUnlock();
            Location[][] map = WorldMap.getWorldInstance().getWorldMap();

            // Parcours de toutes les salles pour trouver celle à déverrouiller
            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map[r].length; c++) {
                    Location loc = map[r][c];
                    if (loc.getName().equalsIgnoreCase(targetLocationName)) {
                        if (loc.getState()) {
                            return "Room \"" + loc.getName() + "\" is already unlocked.";
                        } else {
                            loc.setState(true);
                            return "You have used the \"" + key.getName() +
                                    "\" and unlocked the room : " + loc.getName();
                        }
                    }
                }
            }
            return "No room corresponds to this key.";
        }
        if (item instanceof Letter letter){
            System.out.printf("You can't use a letter, but you can inspect it.");
            System.out.println(" ");
            return "";
        }

        if (item instanceof Dice dice) {
            int result = dice.rollDice();

            if (result == 1) {
                System.out.println("You rolled 1...Critical miss...A trap activates and an axe falls on your head.");
                System.out.println("You died.");
                System.out.println("Maybe you'll get luckier next time...");
                Game.getGameInstance().setIsRunning(false);
                return "";
            }

            if (result == 5 || result == 4 || result == 3 || result == 2) {
                // Grant the key for the final zone ("A locked door")
                Key finalKey = new Key("Final key", "A locked door");
                Player.getInstance().getInventory().addItem(finalKey);
                return "You rolled 20 ! Critical success! You receive: " + finalKey.getName() + " (use it to open \"A locked door\").";
            }
        }

        if (item instanceof Glass glass){
            System.out.println("Why did you drink that? I told you not to.");
            System.out.println("You died.");
            Game.getGameInstance().setIsRunning(false);
            return "";
        }

        return "This object cannot be used.";
    }
}
