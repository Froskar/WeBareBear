package main.items;

public class Glass extends Item{

    public Glass(String name) {
        this.name = name;
    }

    public String getGlass() {
        return name;
    }

    @Override
    public String getDescription() {
        return "A strange glass of wine... I wouldn't drink it if I were you. ";
    }
}
