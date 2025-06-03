package main.commands.commands;

import main.commands.Command;
import main.player.Player;
import main.world.Location;
import main.world.WorldMap;
import static main.world.WorldMap.getWorldInstance;

public class MoveEast extends Command {

    public MoveEast(String name, String descr) {
        super(name, descr);
    }


    @Override
    public String execute() {
        Player player = Player.getInstance();
        WorldMap worldMap = getWorldInstance();
        int row = player.getPosition().getRow();
        int col = player.getPosition().getCol();

        // Vérifie que le joueur n'est pas déjà tout à droite
        if (col == 3) {
            return "Vous ne pouvez pas aller plus au nord.";
        } else if (col==2 && row ==0){
            return "Vous ne pouvez pas aller ici";
        } else if (col == 1 && row == 1) {
            return "Vous ne pouvez pas aller ici";
        }

        // Vérifie si la salle vers laquelle on veut aller est accessible
        Location nextLocation = worldMap.getWorldMap()[row][col+1];
        if (!nextLocation.getState()) {
            return "Cette pièce est verrouillée. Impossible d'y accéder.";
        }
        else {
            Player.getInstance().getPosition().setCol(col+1);
            return "Vous êtes maintenant dans :  " + nextLocation.getName() +" - "+ nextLocation.getDescription();
        }

    }
}
