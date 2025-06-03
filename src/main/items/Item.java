package main.items;
import java.util.Map;
import java.util.HashMap;

public abstract class Item {
    protected String name;
    protected String description;
    private Map<String, Item> itemMap = new HashMap<>();

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getItemDescription(){
        return this.description;
    }

    public Map<String, Item> getItems() {
        return this.itemMap; // ou inventory, selon le nom réel de ta variable
    }

    public abstract String getDescription(); // à redéfinir dans chaque classe
}
