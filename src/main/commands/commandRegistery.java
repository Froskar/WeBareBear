package main.commands;

import java.util.*;

import main.commands.commands.*;

public class CommandRegistery {
    private final HashMap<String, Command> commandes;

    public CommandRegistery() {
        commandes = new HashMap<>();
        // Commandes de base
        addCommand("help", new help("help", "Liste des commandes"));
        addCommand("movenorth", new MoveNorth("movenorth", "Se déplacer au Nord"));
        addCommand("movesouth", new MoveSouth("movesouth", "Se déplacer au sud"));
        addCommand("movewest", new MoveWest("moveWest", "Se déplacer à l'ouest"));
        addCommand("moveeast", new MoveEast("moveeast", "Se déplacer à l'est"));
        addCommand("map", new map("map", "Liste des commandes"));
        addCommand("take", new Take("take", "Prend un objet pour le mettre dans l'inventaire"));
        addCommand("look", new Look("look", "Permet de voirs quels objets sont dans la pièce où vous vous trouvez"));
        addCommand("use", new Use("use", "Permet d'utiliser un objet, soit la lettre soit la clé"));
        addCommand("inventory", new ShowInventory("Inventory", "Permet d'afficher tous les objets dans votre inventaire"));

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
