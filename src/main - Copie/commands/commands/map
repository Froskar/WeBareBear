package main.commands.commands;

import main.commands.Command;
import main.player.Player;
import main.world.WorldMap;
import utils.Array2Dprinter;
import main.player.Position;

public class map extends Command {
    private final WorldMap worldMap;
    public map(String name, String descr) {
        super(name, descr);
        this.worldMap = WorldMap.getWorldInstance();
    }
    @Override
    public String execute(){
        String affichage = Array2Dprinter.print2DArray(worldMap.getWorldMap(), Player.getInstance().getPosition().getRow(), Player.getInstance().getPosition().getCol());
        return affichage;
    }
}

