package main.commands.commands;

import main.commands.Command;
import main.player.Player;
import main.player.Inventory;
import main.items.Item;
import main.items.Letter;
import main.items.Puzzle;
import main.items.Key;

import java.util.Scanner;
public class Say extends Command {

    public Say(String name, String descr, boolean commandState) {
        super(name, descr, commandState);
    }

    @Override
    public String execute() {
        Player player = Player.getInstance();
        Inventory inventory = player.getInventory();

        // Prompt the user for their answer
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you say? ");
        String response = scanner.nextLine().trim().toLowerCase();

        // Check all items in the inventory
        for (Item item : inventory.getItems().values()) {
            if (item instanceof Letter) {
                Letter letter = (Letter) item;
                Puzzle puzzle = letter.getPuzzle();

                // If the riddle is not yet solved and the answer is correct
                if (!puzzle.isSolved() && puzzle.trySolve(response)) {
                    // Retrieve the key stored inside the letter
                    Key key = letter.getKey();
                    // Add that key to the inventory
                    inventory.addItem(key);
                    return "Well done! You solved the riddle and received: " + key.getName();
                }
            }
        }

        return "Nothing happens... (either you have no unsolved letter, or the answer is wrong.)";
    }
}
