package main.world;

import main.Game;
import main.items.*;
import main.items.Object;

public class WorldMap {

    int rows = 3;
    int cols = 4;

    // Créer un tableau bidimensionnel
    Location[][] tableau = new Location[rows][cols];


    private WorldMap() {
        tableau[0][0] = new Location("Storage room", "A wine and food storage room.", true);
        tableau[0][1] = new Location("Narrow hallway", "A narrow hallway that's hard to squeeze through.", true);
        tableau[0][2] = new Location("Throne room", "A gigantic room, full of relics from an ancient time.", true);
        tableau[0][3] = new Location("Cachot", "A dark, damp dungeon, where there are still bones and the amoebae are chilling...", false);
        tableau[1][0] = new Location("Cave", "An old cave, with cobwebs and rats running around when you arrive.", true);
        tableau[1][1] = new Location("Hole in the ground", "BAM ! You've fallen into a hole. Fortunately, there's a rope to pull you out.", true);
        tableau[1][2] = new Location("Reception room", "Skeletons around a table, they must have been feasting in those days.", false);
        tableau[1][3] = new Location("Main corridor", "A large corridor, with imposing statues of guards lining the sides.", true);
        tableau[2][0] = new Location("A locked door", "You are in a secret room filled with magical items... But you see a door at the end, you feel a breeze through the door. Maybe you can escape !", false);
        tableau[2][1] = new Location("Dirty passageway", "BEURK ! A passageway with cobwebs, rotting water seeping into your shoes.", true);
        tableau[2][2] = new Location("Straicases", "Great, stairs! A few steps are damaged but you manage to climb over them.", true);
        tableau[2][3] = new Location("Torture chamber", "A torture chamber, with instruments of torture hanging on the walls and blood drying on the floor.", false);

        Puzzle puzzle1 = new Puzzle("énigme_1",
                "3 fish are in a bucket, one of them dies, how many are left?",
                "3",
                "Torture chamber");

        Puzzle puzzle2 = new Puzzle("énigme_2",
                "What can be in the sea and in the sky?",
                "Star",
                "Cachot");

        Puzzle puzzle3 = new Puzzle("énigme_3",
                "Which is lighter: two kilos of stone or two kilos of sweets?",
                "None",
                "Reception room");


        //création des clés
        Key key1 = new Key("Bloody key", "Torture chamber");
        Key key2 = new Key("Old key", "Cachot");
        Key key3 = new Key("Golden key", "Reception room");


        Letter letter1 = new Letter("Wet letter",puzzle1, key1);
        Letter letter2 = new Letter("Chained letter", puzzle2, key2);
        Letter letter3 = new Letter("Stained letter", puzzle3, key3);
        Crystal crystal = new Crystal("Crystal");
        Dice dice = new Dice("D20");

        //objets qui ne peuvent pas êtres pris
        Object object1 = new Object("Flask","A glass flask filled with a potion");

        //  Ajout des objets dans des locations
        tableau[2][2].addItem(letter1);
        tableau[1][2].addItem(letter2);
        tableau[1][3].addItem(letter3);
        tableau[1][2].addItem(crystal);
        tableau[0][3].addItem(dice);
        tableau[0][0].addItem(object1);
    }

    public Location[][] getWorldMap() {
        return tableau;
    }

    private static WorldMap INSTANCE;

    public static WorldMap getWorldInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WorldMap();
        }
        return INSTANCE;
    }

    public static int[] getLocationCoordinates(String locationName) {
        Location[][] map = getWorldInstance().getWorldMap();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Location loc = map[i][j];
                if (loc != null && loc.getName().equalsIgnoreCase(locationName)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }



}

