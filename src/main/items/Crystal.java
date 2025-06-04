package main.items;

import main.commands.Command;
import main.player.Player;
import main.player.Inventory;
import main.items.Item;

import java.util.Locale;

public class Crystal extends Item {

    public Crystal (String name){
        this.name = name.toLowerCase();
    }

    @Override
    public String getDescription() {
        return "A magic crystal that teleports you";
    }
}
