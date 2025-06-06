package main.commands;

import java.util.*;

import main.commands.commands.*;

public class CommandRegistery {
    private final HashMap<String, Command> commandes;

    public CommandRegistery() {
        commandes = new HashMap<>();
        // Commandes de base
        addCommand("help", new help("help", "List of commands",true));
        addCommand("up", new MoveNorth("up", "Move up",true));
        addCommand("down", new MoveSouth("down", "Move down",true));
        addCommand("left", new MoveWest("left", "Move left",true));
        addCommand("right", new MoveEast("right", "Move right",true));
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
    //-------------------------------------------------------------------//

    public List<Map.Entry<String, String>> getCommandesDisponibles(Player player) {
    List<Map.Entry<String, String>> disponibles = new ArrayList<>(commandes);

    // Ajouter "Inspect" si une lettre est dans la salle
    for (Object item : player.getCurrentLocation().getItems()) {
        if (item instanceof Letter) {
            disponibles.add(new AbstractMap.SimpleEntry<>("Inspect", "Lire la lettre présente dans la pièce."));
            break;
        }
    }

    // Ajouter "Say" si une lettre est dans l'inventaire
    for (Object item : player.getInventory()) {
        if (item instanceof Letter) {
            disponibles.add(new AbstractMap.SimpleEntry<>("Say", "Donner votre réponse à l’énigme de la lettre."));
            break;
        }
    }

    return disponibles;
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
