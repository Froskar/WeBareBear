package main.commands;

public abstract class Command {
    String name;
    String descr;
    boolean commandState;

    public Command(String name, String descr,boolean commandState){
        this.name = name;
        this.descr = descr;
        this.commandState = commandState;
    }

    public String getDescription() {
        return descr;
    }
    public boolean getCommandState(){
        return this.commandState;
    }

    public String getName() {
        return name;
    }
   public abstract String execute();

    public void setCommandState(boolean state) {
        this.commandState = state;
    }
}
