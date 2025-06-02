package main.commands.commands;

import main.commands.Command;
import main.player.Position;
import main.player.player;
import main.world.Location;
import main.world.WorldMap;

import static main.player.player.getPlayerInstance;
import static main.world.WorldMap.getWorldInstance;

public class MoveNorth extends Command {

    public MoveNorth(String name, String descr) {
        super(name, descr);
    }


    @Override
    public String execute() {
        player player = getPlayerInstance();
        WorldMap worldMap = getWorldInstance();
        int row = player.getPosition().getRow();
        int col = player.getPosition().getCol();

        // Vérifie que le joueur n'est pas déjà en haut
        if (row == 0) {
            return "Vous ne pouvez pas aller plus au nord.";
        }

        // Vérifie si la salle vers laquelle on veut aller est accessible
        Location nextLocation = worldMap.getWorldMap()[row - 1][col];
        if (!nextLocation.getState()) {
            return "Cette pièce est verrouillée. Impossible d'y accéder.";
        }
        else {
            player.getPosition().setRow(row - 1);
            return "Vous vous déplacez vers : " + nextLocation.getName();
        }

    }
}