package main.commands.commands;

import main.commands.Command;

import java.util.List;
import java.util.Map;


public class help extends Command {

    @Override
    execute{
        List<Map.Entry<String, String>> commandes = registry.getCommandes();
        System.out.println("Commandes disponibles :");
        for (Map.Entry<String, String> commande : commandes) {
            System.out.println(" - " + commande.getKey() + ": " + commande.getValue());
        }
    }
}