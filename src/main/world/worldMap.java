package main.world;

import main.Game;
import main.items.Crystal;
import main.items.Key;
import main.items.Letter;
import main.items.Puzzle;

public class WorldMap {

    int rows = 3;
    int cols = 4;

    // Créer un tableau bidimensionnel
    Location[][] tableau = new Location[rows][cols];


    private WorldMap() {
        tableau[0][0] = new Location("Salle de stockage", "Une salle de stockage pour le vin et la nourriture", true);
        tableau[0][1] = new Location("Couloir étroit", "Un couloir étroit, on peine a s'y faufiler", true);
        tableau[0][2] = new Location("Salle du trône", "Une salle gigantesque, pleine de reliques d'un ancien temps.", true);
        tableau[0][3] = new Location("Cachot", "Un cachot sombre et humide, il reste encore des os et l'amibance est glaçante...", false);
        tableau[1][0] = new Location("Cave", "Une vielle cave, avec des toiles d'arreignées, des rats courent au moment où vous arrivez", true);
        tableau[1][1] = new Location("Trou dans le sol", "BAM ! Vous êtes tombés dans un trou. Heureusement, une corde vous permet d'en ressortir", true);
        tableau[1][2] = new Location("Salle de réception", "Des squelettes autour d'une table, ils devaient bien festoyer à l'époque.", false);
        tableau[1][3] = new Location("Couloir principal", "Un grand couloir, sur les côtés sont allignés des statues de gardes imposantes", true);
        tableau[2][0] = new Location("Une porte fermée", "C'est une porte, elle est fermée, rien de plus...", false);
        tableau[2][1] = new Location("Passage crasseux", "BEURK ! Un passage avec des toiles d'araignées, de l'eau croupie s'infiltre dans vos chaussures", true);
        tableau[2][2] = new Location("Escaliers", "Super, des escaliers ! Quelques marches sont endommagés mais vous parvenez à les enjamber", true);
        tableau[2][3] = new Location("Salle de torture", "Une salle de torture, avec des instruments de torture accrochés au mur.", false);


        Puzzle puzzle1 = new Puzzle("énigme_1",
                "Mon premier est une lettre de l'alphabet\n" +
                "Mon deuxième est un oiseau qui aime tout ce qui brille. \n" +
                "Mon troisième est un talent particulier que l'on peut avoir. \n" +
                "Mon tout a beaucoup de travail le jour de la Saint-Valentin",
                "dragon",
                "Salle de torture");

        Puzzle puzzle2 = new Puzzle("énigme_2",
                "Qu'est-ce qui peut être dans la mer et dans le ciel ?",
                "Une étoile",
                "Cachot");

        Puzzle puzzle3 = new Puzzle("énigme_3",
                "canards se baignent dans mon premier. \n" +
                "Mon deuxième est l'inverse de tard. \n" +
                "Mon tout sert à enfoncer des clous",
                "Marteau",
                "Salle de réception");


        //création des clés
        Key key1 = new Key("clé_torture", "Salle de torture");
        Key key2 = new Key("clé_cachot", "Cachot");
        Key key3 = new Key("clé_reception", "Salle de réception");


        Letter letter1 = new Letter("lettre_1",puzzle1, key1);
        Letter letter2 = new Letter("lettre_2", puzzle2, key2);
        Letter letter3 = new Letter("lettre_3", puzzle3, key3);
        Crystal crystal = new Crystal("Crystal");

        //  Ajout des objets dans des locations
        tableau[0][0].addItem(letter1);
        tableau[0][1].addItem(letter2);
        tableau[1][1].addItem(letter3);
        tableau[0][0].addItem(crystal);
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

