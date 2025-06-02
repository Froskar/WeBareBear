package main.commands.commands;

import main.commands.Command;
import main.player.player;
import main.world.Location;
import main.world.worldMap;

public class MoveNorth extends Command {

    private final worldMap worldMap;

    public MoveNorth(String name, String descr, worldMap worldMap ){
        super(name, descr);
        this.worldMap = main.world.worldMap.getWorldInstance();
    }



    //c'est pas getPLayerPosition mais getPlayerLocation
        if (player. > 0) {
            worldMap.getPlayerPosition().setY(worldMap.getPlayerPosition().getY() - 1);
        } else {
            System.out.println("You can't move north, you're at the top of the map.");
        }

        Location location = worldMap.getWorldMap()[worldMap.getPlayerPosition().getX()][worldMap.getPlayerPosition().getY()];
        // vérifie si la zone est vérouillée ou non
        if(location.state()== false) {
            System.out.println("You can't move, the location is not accessible.");
            return;
        }
        // mets à jour la position du joueur
        worldMap.getPlayerPosition().setY(worldMap.getPlayerPosition().getY() + 1);
        setLocation(worldMap.getPlayerPosition().getX(), worldMap.getPlayerPosition().getY());

    @Override
    public String execute() {
        return "";
    }
}

