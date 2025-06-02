package main.commands;

import java.util.*;
import main.commands.commands.help;

public class commandRegistery {
    private final HashMap<String, Command> commandes;

    public commandRegistery() {
        commandes = new HashMap<>();
        // Commandes de base
        addCommand("help", new help("help", "Liste des commandes"));
        addCommand("move", new help("help", "Liste des commandes"));
        addCommand("look", new help("help", "Liste des commandes"));
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

    private static commandRegistery INSTANCE;
    public static commandRegistery getCommandInstance() {
        if (INSTANCE == null) {
            INSTANCE = new commandRegistery();
        }
        return INSTANCE;
    }
    public Command getCommand (String input){
        return this.commandes.get(input);
    }
}
