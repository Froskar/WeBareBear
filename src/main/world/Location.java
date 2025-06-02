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
        if (item.getName() != null) {
            items.put(item.getName(), item);
        } else {
            System.out.println("Tentative d'ajout d'un item sans nom !");
        }
    }
    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    public boolean hasItems() {
        return !items.isEmpty();
    }
    public String listItems() {
        if (items.isEmpty()) {
            return "Il n'y a aucun objet ici.";
        }

        StringBuilder sb = new StringBuilder("Objets présents :\n");
        for (String itemName : items.keySet()) {
            sb.append(" - ").append(itemName).append("\n");
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