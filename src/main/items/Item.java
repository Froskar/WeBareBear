package main.items;

public abstract class Item {
    protected String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract String getDescription(); // à redéfinir dans chaque classe
}
