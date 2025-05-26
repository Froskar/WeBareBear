package main.commands;

import commands.commands.map;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import main.Game;
import main.commands.commands.help;

public class commandRegistery {

    private final List<Map.Entry<String, String>> commandes;

    public commandRegistery() {
        commandes = new ArrayList<>();
        // Commandes de base
        addCommand("Help", "Affiche la liste de toutes les commandes disponibles.");
        addCommand("Move", "Démarre une nouvelle partie.");
        addCommand("Look", "Sauvegarde la partie actuelle.");
        addCommand("Take", "Quitte le jeu.");
        
        
    }

    // Ajouter une commande
    public void addCommand(String nom, String description) {
        commandes.add(new AbstractMap.SimpleEntry<>(nom, description));
    }

    // Supprimer une commande
    public void removeCommand(String nom) {
        commandes.removeIf(commande -> commande.getKey().equalsIgnoreCase(nom));
        System.out.println("Commande '" + nom + "' supprimée.");
    }

    public List<Map.Entry<String, String>> getCommandes() {
        return commandes;
    }

    public void commandChoose() {
        Game game = new Game();
        String command = game.getCommandInput();
        switch (command.toLowerCase()) {
            case "map" -> {
                displayMap();
            }
            case "help" -> {
                displayHelp();
            }
            default -> {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
