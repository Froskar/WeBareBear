package main.commands.commands;

import main.Game;
import main.commands.Command;
import main.player.Player;
import main.world.WorldMap;
import utils.Array2Dprinter;
import main.player.Position;

public class map extends Command {
    private final WorldMap worldMap;
    public map(String name, String descr, boolean commandState) {
        super(name, descr,commandState);
        this.worldMap = WorldMap.getWorldInstance();
    }
    @Override
    public String execute(){
        return Array2Dprinter.print2DArray(WorldMap.getWorldInstance().getWorldMap(), Player.getInstance().getPosition().getRow(), Player.getInstance().getPosition().getCol());
    }
}

