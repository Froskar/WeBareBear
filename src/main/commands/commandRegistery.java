package main.commands;

import java.util.*;

import main.commands.commands.*;

public class CommandRegistery {
    private final HashMap<String, Command> commandes;

    public CommandRegistery() {
        commandes = new HashMap<>();
        // Commandes de base
        addCommand("help", new help("help", "List of commands",true));
        addCommand("up", new MoveNorth("up", "Move north",true));
        addCommand("down", new MoveSouth("down", "Move south",true));
        addCommand("left", new MoveWest("left", "Move west",true));
        addCommand("right", new MoveEast("right", "Move east",true));
        addCommand("map", new map("map", "View map",true));
        addCommand("take", new Take("take", "Takes an item and puts it in the inventory",true));
        addCommand("look", new Look("look", "See what objects are in the room you are in",true));
        addCommand("use", new Use("use", "Allows you to use an object, either the letter or the key",true));
        addCommand("inventory", new ShowInventory("Inventory", "Displays all the items in your inventory",true));
        addCommand("teleport",new Teleport("teleport","Teleports you wherever you want",false));
        addCommand("say",new Say("say","With this command you can answer riddles",true));
        addCommand("inspect", new Inspect("inspect","Give a close-up of an object",true));

    }

    // Ajouter une commande
    public void addCommand(String nom, Command commande) {
        commandes.put(nom, commande);
    }

    //suprimer une commande
    public void removeCommand(String nom) {
        if (commandes.containsKey(nom)) {
            commandes.remove(nom);
            System.out.println("Command '" + nom + "' deleted.");
        } else {
            System.out.println("Command '" + nom + "' not found.");
        }
    }

    public HashMap<String, Command> getCommandRegistery() {
        return commandes;
    }

    private static CommandRegistery INSTANCE;
    public static CommandRegistery getCommandInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommandRegistery();
        }
        return INSTANCE;
    }
    public Command getCommand (String input){
        return this.commandes.get(input);
    }
}
