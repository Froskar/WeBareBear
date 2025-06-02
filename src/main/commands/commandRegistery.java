package main.commands;

import java.util.*;

import main.commands.commands.MoveNorth;
import main.commands.commands.help;
import main.commands.commands.map;

public class CommandRegistery {
    private final HashMap<String, Command> commandes;

    public CommandRegistery() {
        commandes = new HashMap<>();
        // Commandes de base
        addCommand("help", new help("help", "Liste des commandes"));
        addCommand("movenorth", new MoveNorth("movenorth", "Se déplacer au Nord"));
        addCommand("map", new map("map", "Liste des commandes"));
        addCommand("take", new help("help", "Liste des commandes"));
    }

    // Ajouter une commande
    public void addCommand(String nom, Command commande) {
        commandes.put(nom, commande);
    }

    //suprimer une commande
    public void removeCommand(String nom) {
        if (commandes.containsKey(nom)) {
            commandes.remove(nom);
            System.out.println("Commande '" + nom + "' supprimée.");
        } else {
            System.out.println("Commande '" + nom + "' introuvable.");
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
