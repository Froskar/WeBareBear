package main.commands.commands;

import main.commands.Command;
import main.player.Player;
import main.world.Location;
import main.world.WorldMap;

import static main.world.WorldMap.getWorldInstance;

public class Look extends Command {

    public Look(String name, String descr) {
        super(name, descr);
    }

    @Override
    public String execute() {
        Player player = Player.getInstance();
        WorldMap worldMap = getWorldInstance();

        int row = Player.getInstance().getPosition().getRow();
        int col = Player.getInstance().getPosition().getCol();
        Location currentLocation = worldMap.getWorldMap()[row][col];

        StringBuilder sb = new StringBuilder();
        sb.append("Vous êtes dans : ").append(currentLocation.getName()).append("\n");
        sb.append(currentLocation.getDescription()).append("\n\n");
        sb.append(currentLocation.listItems());

        return sb.toString();
    }


}
