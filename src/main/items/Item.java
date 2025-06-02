package main.items;

public abstract class Item {
    protected String name;
    protected boolean InIventory;

    public String getName() {
        return name;
    }
    public boolean getInInventory(){
        return this.InIventory;
    }
}
