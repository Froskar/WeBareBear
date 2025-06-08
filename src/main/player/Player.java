package main.player;

import main.world.Location;
import main.world.WorldMap;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Position position;
    private final Inventory inventory;
    private final Set<Location> visitedLocations; // <- on l'ajoute

    private static Player INSTANCE;

    public Player(String hero) {
        String name = "Hero";
        this.position = new Position(0, 0);
        this.inventory = new Inventory();
        this.visitedLocations = new HashSet<>();
        // On marque la position initiale comme visitée
        Location start = WorldMap.getWorldInstance().getWorldMap()[0][0];
        visitedLocations.add(start);
    }

    public static Player getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Player("Hero");
        }
        return INSTANCE;
    }

    public Position getPosition() {
        return position;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Set<Location> getVisitedLocations() {
        return visitedLocations;
    }

    public void markVisited(Location loc) {
        visitedLocations.add(loc);
    }
}
