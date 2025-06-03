package main.items;

public abstract class Item {
    protected String name;

    public String getName() {
        return name;
    }

    // Chaque sous-classe doit redéfinir cette méthode
    public abstract String getDescription();
}
