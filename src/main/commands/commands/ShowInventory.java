package main.commands.commands;

import main.commands.Command;
import main.items.Item;
import main.player.Player;

import java.util.Map;

public class ShowInventory extends Command {

    public ShowInventory(String name, String descr, boolean commandState) {
        super(name, descr,commandState);
    }

    @Override
    public String execute() {
        return Player.getInstance().getInventory().listItems();
    }
}
