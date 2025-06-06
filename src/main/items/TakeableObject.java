package main.items;

public class TakeableObject extends Item {
    String descr;
    public TakeableObject(String name, String descr) {
        this.name = name;
        this.descr = descr;
    }

    public String getTakableObject() {
        return name;
    }

    @Override
    public String getDescription() {return this.descr;}
}

