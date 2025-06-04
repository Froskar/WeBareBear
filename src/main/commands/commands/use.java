package main.commands.commands;

import main.commands.Command;
import main.items.Item;
import main.items.Key;
import main.items.Letter;
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
        System.out.print("Quel objet voulez-vous utiliser ? > ");
        String itemName = scanner.nextLine().trim();

        // Récupérer l'item
        Item item = player.getInventory().getItem(itemName);
        if (item == null) {
            return "Vous ne possédez pas cet objet.";
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
                            return "La salle \"" + loc.getName() + "\" est déjà déverrouillée.";
                        } else {
                            loc.setState(true);
                            return "Vous avez utilisé la clé \"" + key.getName() +
                                    "\" et déverrouillé la salle : " + loc.getName();
                        }
                    }
                }
            }
            return "Aucune salle ne correspond à cette clé.";
        }

        if (item instanceof Letter letter) {
            return "Vous lisez la lettre :\n" + letter.read();
        }

        return "Cet objet ne peut pas être utilisé.";
    }
}
