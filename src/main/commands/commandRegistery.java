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
