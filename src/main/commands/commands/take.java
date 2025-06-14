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
        System.out.print("Which item do you want to take? ");
        String itemName = scanner.nextLine().trim();

        if (!currentLocation.getItems().containsKey(itemName)) {
            return "There is no such object in this room.";
        }

        Item item = currentLocation.getItems().get(itemName);

        if (!item.isTakeable()) {
            return "You cannot take \"" + item.getName() + "\".";
        }


        if (item instanceof main.items.Crystal) {
            Command commandTeleport = CommandRegistery.getCommandInstance().getCommand("teleport");
            if (commandTeleport != null) {
                commandTeleport.setCommandState(true);
            }
            currentLocation.removeItem(itemName);
            inventory.addItem(item);
            return "You have picked up : " + item.getName() + ". The teleport command is now available!";
        }
        currentLocation.removeItem(itemName);
        inventory.addItem(item);
        return "You have picked up : " + item.getName();
    }
}
