package main.player;

public class player {
    String name;
    int LocationRow = 0;
    int locationColumn = 0;

    private final Position position = new Position(0, 0);

    public Position getPosition() { return position; }

    public String getName() {
        return this.name;
    }
    private static player INSTANCE;
    public static player getPlayerInstance() {
        if (INSTANCE == null) {
            INSTANCE = new player();
        }
        return INSTANCE;
    }
}

