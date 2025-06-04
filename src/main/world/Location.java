package main.world;

import main.items.Item;
import utils.IPrintable;

import java.util.HashMap;
import java.util.Map;

public class Location implements IPrintable {
    private final String name;
    private final String description;
    private boolean state;
    private final HashMap<String, Item> items;

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

    public void setState(boolean newState) {
        this.state = newState;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.put(item.getName().toLowerCase(), item);
    }

    public Item removeItem(String itemName) {
        return items.remove(itemName.toLowerCase());
    }

    public boolean hasItems() {
        return !items.isEmpty();
    }

    public String listItems() {
        if (items.isEmpty()) {
            return "Il n'y a aucun objet ici.";
        }
        StringBuilder sb = new StringBuilder("Objets présents :\n");
        for (Map.Entry<String, Item> entry : items.entrySet()) {
            sb.append(" - ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
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
