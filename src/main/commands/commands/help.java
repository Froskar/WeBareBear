package main.commands.commands;

import main.commands.Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.commands.CommandRegistery;


public class help extends Command {

    public help(String name, String descr) {
        super(name, descr);
    }

    @Override
    public String execute() {
        HashMap<String, Command> commandes = CommandRegistery.getCommandInstance().getCommandRegistery();

        String output = "Commandes disponibles :\n";

        for (String nom : commandes.keySet()) {
            output += " - " + nom + "\n";
        }

        return output;
    }
}