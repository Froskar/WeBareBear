package main.commands.commands;

import main.commands.Command;
import main.player.Player;
import main.world.Location;
import main.world.WorldMap;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import static main.world.WorldMap.getWorldInstance;

public class Look extends Command {

    public Look(String name, String descr, boolean commandState) {
        super(name, descr, commandState);
    }

    @Override
    public String execute() {
        Player player = Player.getInstance();
        WorldMap worldMap = getWorldInstance();

        int row = player.getPosition().getRow();
        int col = player.getPosition().getCol();
        Location currentLocation = worldMap.getWorldMap()[row][col];

        // Affichage direct via System.out
        System.out.println(StringStyling.StyleString(("You are in: " + currentLocation.getName()), Style.UNDERLINE, Color.WHITE));
        System.out.println(currentLocation.getDescription());
        System.out.println(StringStyling.StyleString(("---+---"), Style.NORMAL, Color.BLACK));
        System.out.println(currentLocation.listItems());
        return "";
    }
}
