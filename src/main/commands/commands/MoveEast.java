package main.commands.commands;

import main.commands.Command;
import main.player.Player;
import main.world.Location;
import main.world.WorldMap;
import static main.world.WorldMap.getWorldInstance;

public class MoveEast extends Command {

    public MoveEast(String name, String descr, boolean commandState) {
        super(name, descr,commandState);
    }


    @Override
    public String execute() {
        Player player = Player.getInstance();
        WorldMap worldMap = getWorldInstance();
        int row = player.getPosition().getRow();
        int col = player.getPosition().getCol();

        // Vérifie que le joueur n'est pas déjà tout à droite
        if (col == 3) {
            return "You can't go any further right";
        } else if (col == 1 && row == 1) {
            return "You can't go here, there is a wall...";
        }else if (col == 0 && row == 2) {
            return "You can't go here, there is a wall...";
        }

        // Vérifie si la salle vers laquelle on veut aller est accessible
        Location nextLocation = worldMap.getWorldMap()[row][col+1];
        if (!nextLocation.getState()) {
            return "This room is locked. Impossible to access.";
        }
        else {
            Player.getInstance().getPosition().setCol(col+1);
            player.markVisited(nextLocation);
            return "You are now in :  " + nextLocation.getName() +" - "+ nextLocation.getDescription();

        }

    }
}
