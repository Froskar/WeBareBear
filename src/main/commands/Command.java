package main.commands;

public abstract class Command {
    String name;
    String descr;

    public Command(String name, String descr){
        this.name = name;
        this.descr = descr;
    }

    public String getDescription() {
        return descr;
    }

    public String getName() {
        return name;
    }
   public abstract String execute();
}
