package main.player;
import main.player.Position;

public class Player {
    private final String name;
    private final Inventory inventory;
    private final Position position;

    // Singleton
    private static Player INSTANCE;
    public static Player getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Player("Héro");
        }
        return INSTANCE;
    }

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.position =  new Position(0, 0);
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Position getPosition() {
        return position;
    }
}
