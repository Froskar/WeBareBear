package main.player;

import main.items.Item;

import java.util.HashMap;

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

    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    public boolean hasItem(String itemName) {
        return items.containsKey(itemName);
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("Votre inventaire est vide.");
        } else {
            System.out.println("Inventaire :");
            for (String key : items.keySet()) {
                System.out.println("- " + key);
            }
        }
    }
}