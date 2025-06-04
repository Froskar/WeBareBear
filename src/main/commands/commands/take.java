package main.commands.commands;

import main.commands.Command;
import main.commands.CommandRegistery;
import main.items.Item;
import main.player.Player;
import main.player.Inventory;
import main.world.Location;
import main.world.WorldMap;

import java.util.Scanner;

public class Take extends Command {

    public Take(String name, String descr, boolean commandState) {
        super(name, descr,commandState);
    }

    @Override
    public String execute() {
        Player player = Player.getInstance();
        WorldMap worldMap = WorldMap.getWorldInstance();
        Location currentLocation = worldMap.getWorldMap()[Player.getInstance().getPosition().getRow()][Player.getInstance().getPosition().getCol()];
        Inventory inventory = player.getInventory();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Quel objet voulez-vous prendre ? ");
        String itemName = scanner.nextLine().trim();

        if (!currentLocation.getItems().containsKey(itemName)) {
            return "Cet objet n’est pas présent ici.";
        }
        Item item = currentLocation.removeItem(itemName);
        inventory.addItem(item);

        if (item instanceof main.items.Crystal) {
            Command commandTeleport = CommandRegistery.getCommandInstance().getCommand("teleport");
            if (commandTeleport != null) {
                commandTeleport.setCommandState(true);
            }
            return "Vous avez récupéré : " + item.getName() + ". La commande teleport est maintenant disponible !";
        }
        return "Vous avez récupéré : " + item.getName();
    }
}
