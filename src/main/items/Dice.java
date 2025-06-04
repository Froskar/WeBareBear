package main.items;

public class Dice extends Item {
    public Dice(String name) {
        this.name = name;
    }

    public String getDice() {
        return name;
    }

    public int rollDice(){
        return (int)(Math.random() * 6) + 1;
    }

    @Override
    public String getDescription() {
        return "A dice with 20 faces maybe you should roll it";
    }
}
