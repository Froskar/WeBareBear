package main.player;

import main.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final HashMap<String, Item> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    public Item getItem(String name) {
        for (String key : items.keySet()) {
            if (key.equalsIgnoreCase(name)) {
                return items.get(key);
            }
        }
        return null;
    }

    public boolean hasItem(String itemName) {
        return items.containsKey(itemName);
    }

    public String listItems() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory :");
            for (String key : items.keySet()) {
                System.out.println("- " + key);
            }
        }
        return null;
    }
    public Map<String, Item> getItems() {
        return items;
    }

}