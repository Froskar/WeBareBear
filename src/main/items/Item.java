package main.items;

public abstract class Item {
    protected String name;
    protected  boolean takeable = true;

    public String getName() {
        return name;
    }

    public boolean isTakeable(){
        return takeable;
    }

    public void setTakeable(boolean state) {
        this.takeable = state;
    }


    // Chaque sous-classe doit redéfinir cette méthode
    public abstract String getDescription();
}
