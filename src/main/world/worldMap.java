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
        tableau[0][0] = new Location("Storage room", "Here you are in a storage room, full of old wine barrels and bread harder than stone. \nProbably abandoned for years.", true);
        tableau[0][1] = new Location("Narrow hallway", "You cross a narrow corridor. It's hard to squeeze through, but you manage.\n But you end up with a lot of cobwebs all over your face.", true);
        tableau[0][2] = new Location("Throne room", "Here you are in a gigantic room, filled with relics from a bygone age. In the middle is a throne, probably that of Queen Dagmar.\n The Queen's chair has fallen over, but a glass is still half full  next to it. \nI wouldn't drink it if I were you. ", true);
        tableau[0][3] = new Location("Cachot", " You enter a dark, damp room. On the door is an inscription: \"Cachot\", you enter and come face to face with skeletons. \nThe atmosphere is chilling. I wouldn't hang around here if I were you - who knows, maybe the place is haunted? ", false);
        tableau[1][0] = new Location("Cave", "An old cave, with cobwebs and rats running around when you arrive.", true);
        tableau[1][1] = new Location("Hole in the ground", "BAM!! Oh noooo, you've fallen into a hole. \nYou look around and find a rope, luckily you can get out again if you're too scared to cross the underpass. \n", true);
        tableau[1][2] = new Location("Reception room", "Wow, you've just discovered what appears to be a reception room. \nThere's a large table in the middle of the room. Something unusual must have happened here. \nSkeletons are sitting around the table, as if they had died in the middle of a meal.", false);
        tableau[1][3] = new Location("Main corridor", ":You cross the main corridor, with large, dilapidated paintings adorning the walls.\n Armour stands all along the corridor. You feel overwhelmed, has someone followed you? \nOr is it the armour watching you?", true);
        tableau[2][0] = new Location("A locked door", "You are in a secret room filled with magical items... \nBut you see a door at the end, you feel a breeze through the door. \nMaybe you can escape !", false);
        tableau[2][1] = new Location("Dirty passageway", "BEURK !  You've found a passage under the ground, no need to get out of the hole.\n Yuck, you look around you, water is stagnating on the ground, it's seeping into your shoes.\n Grr, a strange noise comes from behind you. I wouldn't hang around here if I were you.", true);
        tableau[2][2] = new Location("Straicases", "Great, stairs! A few steps are damaged but you manage to climb over them.", true);
        tableau[2][3] = new Location("Torture chamber", "You've discovered the torture room, old torture instruments still hanging on the walls. \nThere's dried blood on the floor. Oh, but there seems to be fresh blood on one of the walls...", false);

        Puzzle puzzle1 = new Puzzle("énigme_1",
                "I open doors but do not speak. \nWithout me, your fate is bleak.",
                "Key",
                "Torture chamber");

        Puzzle puzzle2 = new Puzzle("énigme_2",
                "I build the walls, cold and grey. \nI hold the dungeon, cold and old.",
                "Stone",
                "Cachot");

        Puzzle puzzle3 = new Puzzle("énigme_3",
                "You hear me move but I have no feet. \nI howl at night, though the walls and under doors",
                "Wind",
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
        Glass glass = new Glass("Glass");

        //objets qui ne peuvent pas êtres pris
        Object object1 = new Object("Flask","A glass flask filled with a potion");
        Object object2 = new Object("Rope", "A rope to get out of here");
        Object object3 = new Object("Chest","Maybe Dagmar's treasure");
        Object object4 = new Object("Wine bottle", "A very old wine bottle, it must be expensive");

        //Object qui peuvent être pris
        TakeableObject skull = new TakeableObject("Skull", "An old weirdly shaped skull, it looks like Tutankhamun");
        TakeableObject oldCake = new TakeableObject("Old cake", "An old crispy cake, beurk");
        TakeableObject parchment = new TakeableObject("Parchment", "Oh nice, a clue to help solve the puzzle : Without me you can't escape.");
        TakeableObject coin = new TakeableObject("Coin", "Oh nice, a clue to help solve the puzzle : I am everywhere around you, beneath your feet and over your head.");
        TakeableObject necklace = new TakeableObject("Necklace", "Oh nice, a clue to help solve the puzzle : Some say the Queen's last breath still rides on me.");

        //  Ajout des objets dans des locations
        tableau[2][2].addItem(letter1);
        tableau[1][2].addItem(letter2);
        tableau[1][3].addItem(letter3);
        tableau[1][2].addItem(crystal);
        tableau[0][3].addItem(dice);
        tableau[0][0].addItem(object1);
        tableau[0][2].addItem(glass);
        tableau[1][1].addItem(object2);
        tableau[1][0].addItem(object3);
        tableau[0][0].addItem(object4);
        tableau[0][1].addItem(skull);
        tableau[2][1].addItem(oldCake);
        tableau[2][2].addItem(parchment);
        tableau[1][2].addItem(coin);
        tableau[1][3].addItem(necklace);
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

