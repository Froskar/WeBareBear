
package main.commands.commands;

import main.commands.Command;
import main.world.worldMap;

public class move extends Command {


    private final worldMap worldMap;

    public move(String name, String descr, worldMap worldMap ){
        super(name, descr);
        this.worldMap = main.world.worldMap.getWorldInstance();
    }
/*

    //c'est pas getPLayerPosition mais getPlayerLocation
    public void moveNorth() {
        if (worldMap.getPlayerPosition().getY() > 0) {
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
    }

    public void moveSouth() {
        if (worldMap.getPlayerPosition().getY() > 0) {
            worldMap.getPlayerPosition().setY(worldMap.getPlayerPosition().getY() - 1);
        } else {
            System.out.println("You can't move south, you're at the bottom of the map.");
        }

        Location location = worldMap.getWorldMap()[worldMap.getPlayerPosition().getX()][worldMap.getPlayerPosition().getY()];
        // vérifie si la zone est vérouillée ou non 
            if (location.state() == false) {
            System.out.println("You can't move, the location is not accessible.");
            return;
        }
        // mets à jour la position du joueur
        worldMap.getPlayerPosition().setY(worldMap.getPlayerPosition().getY() + 1);
        setLocation(worldMap.getPlayerPosition().getX(), worldMap.getPlayerPosition().getY());

    }

    public void moveEast() {
        if (worldMap.getPlayerPosition().getY() > 0) {
            worldMap.getPlayerPosition().setY(worldMap.getPlayerPosition().getY() - 1);
        } else {
            System.out.println("You can't move north, you're at the right edge of the map.");
        }
        
        Location location = worldMap.getWorldMap()[worldMap.getPlayerPosition().getX()][worldMap.getPlayerPosition().getY()];
        // vérifie si la zone est vérouillée ou non 
            if (location.state() == false) {
            System.out.println("You can't move, the location is not accessible.");
            return;
        }
        // mets à jour la position du joueur
        worldMap.getPlayerPosition().setX(worldMap.getPlayerPosition().getX() + 1);
        setLocation(worldMap.getPlayerPosition().getX(), worldMap.getPlayerPosition().getY());


    }

    public void moveWest() { 
        if (worldMap.getPlayerPosition().getX() > 0) {
            worldMap.getPlayerPosition().setX(worldMap.getPlayerPosition().getX() - 1);
        } else {
            System.out.println("You can't move west, you're at the left edge of the map.");
        }
        
        Location location = worldMap.getWorldMap()[worldMap.getPlayerPosition().getX()][worldMap.getPlayerPosition().getY()];
        // vérifie si la zone est vérouillée ou non 
            if (location.state() == false) {
            System.out.println("You can't move, the location is not accessible.");
            return;
        }
        // mets à jour la position du joueur
        worldMap.getPlayerPosition().setX(worldMap.getPlayerPosition().getX() + 1);
        setLocation(worldMap.getPlayerPosition().getX(), worldMap.getPlayerPosition().getY());

    }
 */
    @Override
    public String execute() {
        return "";
    }
}
