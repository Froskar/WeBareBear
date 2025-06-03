package main.commands.commands;

import main.commands.Command;
import main.player.Position;
import main.player.Player;
import main.world.Location;
import main.world.WorldMap;
import static main.world.WorldMap.getWorldInstance;

public class MoveNorth extends Command {

    public MoveNorth(String name, String descr) {
        super(name, descr);
    }


    @Override
    public String execute() {
        Player player = Player.getInstance();
        WorldMap worldMap = getWorldInstance();

        int row = Player.getInstance().getPosition().getRow();
        int col = Player.getInstance().getPosition().getCol();

        // Vérifie que le joueur n'est pas déjà en haut
        if (row == 0) {
            return "Vous ne pouvez pas aller plus au nord.";
        } else if (col == 2 && row == 1) {
            return "Vous ne pouvez pas aller ici";
        }

        // Vérifie si la salle vers laquelle on veut aller est accessible
        Location nextLocation = worldMap.getWorldMap()[row-1][col];
        if (!nextLocation.getState()) {
            return "Cette pièce est verrouillée. Impossible d'y accéder.";
        }
        else {
            Player.getInstance().getPosition().setRow(row-1);
            return "Vous êtes maintenant dans : " + nextLocation.getName();
        }

    }
}