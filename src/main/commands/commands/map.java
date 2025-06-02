package main.commands.commands;

import main.commands.Command;
import main.world.WorldMap;
import utils.Array2Dprinter;

public class map extends Command {
    private final WorldMap worldMap;
    public map(String name, String descr) {
        super(name, descr);
        this.worldMap = WorldMap.getWorldInstance();
    }
    @Override
    public String execute(){
        String affichage = Array2Dprinter.print2DArray(worldMap.getWorldMap(),0,0);
        return affichage;
    }
}

