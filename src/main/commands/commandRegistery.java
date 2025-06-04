package main.commands;

import java.util.*;

import main.commands.commands.*;

public class CommandRegistery {
    private final HashMap<String, Command> commandes;

    public CommandRegistery() {
        commandes = new HashMap<>();
        // Commandes de base
        addCommand("help", new help("help", "Liste des commandes",true));
        addCommand("up", new MoveNorth("up", "Se déplacer au Nord",true));
        addCommand("down", new MoveSouth("down", "Se déplacer au sud",true));
        addCommand("left", new MoveWest("left", "Se déplacer à l'ouest",true));
        addCommand("right", new MoveEast("right", "Se déplacer à l'est",true));
        addCommand("map", new map("map", "Liste des commandes",true));
        addCommand("take", new Take("take", "Prend un objet pour le mettre dans l'inventaire",true));
        addCommand("look", new Look("look", "Permet de voirs quels objets sont dans la pièce où vous vous trouvez",true));
        addCommand("use", new Use("use", "Permet d'utiliser un objet, soit la lettre soit la clé",true));
        addCommand("inventory", new ShowInventory("Inventory", "Permet d'afficher tous les objets dans votre inventaire",true));
        addCommand("teleport",new Teleport("teleport","Teleports you wherever you want",false));

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
