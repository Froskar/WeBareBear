package main.commands.commands;

import main.commands.Command;
import main.player.Player;
import main.player.Position;
import main.world.Location;
import main.world.WorldMap;

import static main.world.WorldMap.getWorldInstance;

public class MoveSouth extends Command {

    public MoveSouth(String name, String descr, boolean commandState) {
        super(name, descr,commandState);
    }


    @Override
    public String execute() {
        Player player = Player.getInstance();
        WorldMap worldMap = getWorldInstance();
        int row = Player.getInstance().getPosition().getRow();
        int col = Player.getInstance().getPosition().getCol();

        // Vérifie que le joueur n'est pas déjà en bas
        if (row == 2) {
            return "You can't go further down.";
        } else if (col == 2 && row == 1) {
            return "You can't go here there is a wall...";
        }else if (col == 2 && row == 0) {
            return "You can't go here there is a wall...";
        }else if (col == 3 && row == 0) {
            return "You can't go here there is a wall...";
        }


        // Vérifie si la salle vers laquelle on veut aller est accessible
        Location nextLocation = worldMap.getWorldMap()[row+1][col];
        if (!nextLocation.getState()) {
            return "This room is locked. Impossible to access.";
        }
        else {
            Player.getInstance().getPosition().setRow(row+1);
            player.markVisited(nextLocation);
            return "You are now in :  " + nextLocation.getName() +" - "+ nextLocation.getDescription();
        }
    }
}
