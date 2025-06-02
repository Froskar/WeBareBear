package main.commands.commands;

import main.commands.Command;
import utils.Array2Dprinter;
import main.world.worldMap;

public class map extends Command {
    private worldMap worldMap;
    public map(String name, String descr) {
        super(name, descr);
        this.worldMap = main.world.worldMap.getWorldInstance();
    }
    @Override
    public String execute(){
        String affichage = Array2Dprinter.print2DArray(worldMap.getWorldMap(),0,0);
        return affichage;
    }
}

