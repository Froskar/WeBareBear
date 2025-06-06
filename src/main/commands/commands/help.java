package main.commands.commands;

import main.commands.Command;
import main.commands.CommandRegistery;

import java.util.HashMap;

public class help extends Command {

    public help(String name, String descr, boolean commandState) {
        super(name, descr, commandState);
    }

    @Override
    public String execute() {
        HashMap<String, Command> commandes = CommandRegistery
                .getCommandInstance()
                .getCommandRegistery();

        String output = "Available commands :\n";

        for (String nom : commandes.keySet()) {
            Command cmd = commandes.get(nom);
            if (cmd.getCommandState()) {
                String description = cmd.getDescription();
                output += " - " + nom + " : " + description + "\n";
            }
        }

        return output;
    }
}
