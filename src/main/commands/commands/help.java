package main.commands.commands;

import java.util.List;
import java.util.Map;
import main.commands.commandRegistery;


public class help {

    commandRegistery registry = new commandRegistery();

    public void displayHelp() {
        List<Map.Entry<String, String>> commandes = registry.getCommandes();
        System.out.println("Commandes disponibles :");
        for (Map.Entry<String, String> commande : commandes) {
            System.out.println(" - " + commande.getKey() + ": " + commande.getValue());
        }
    }
}