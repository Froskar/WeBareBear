package main.commands.commands;

import main.Game;
import main.commands.Command;
import main.items.Dice;
import main.items.Item;
import main.items.Key;
import main.items.Letter;
import main.player.Player;
import main.world.Location;
import main.world.WorldMap;

import java.util.Scanner;

public class Inspect extends Command {

    public Inspect(String name, String descr, boolean commandState) {
        super(name, descr,commandState);
    }

    @Override
    public String execute() {
        Player player = Player.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which item do you want to Inspect? > ");
        String itemName = scanner.nextLine().trim();

        // Récupérer l'item
        Item item = player.getInventory().getItem(itemName);
        if (item == null) {
            return "You do not own this item.";
        } else {
            System.out.println(Player.getInstance().getInventory().getItem(itemName).getDescription());
        }
        return "";
    }
}