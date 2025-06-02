package main.world;

import main.items.Item;
import utils.IPrintable;

import java.util.HashMap;

public class Location implements IPrintable {

    private final String name;
    private final String description;
    private final boolean state;
    private final HashMap<String, Item> items; // clef = nom de l'item

    public Location(String name, String description, boolean state) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.items = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getState() {
        return state;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    @Override
    public String getPrintableString() {
        return name;
    }

    @Override
    public boolean isGrayedOut() {
        return !state;
    }
}
