package main.world;

import main.Game;
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
        tableau[0][2] = new Location("Salle du trône", "Une salle gigantesque, pleine de reliques d'un ancien temps.",
                true);
        tableau[0][3] = new Location("Cachot",
                "Un cachot sombre et humide, il reste encore des os et l'amibance est glaçante...", false);
        tableau[1][0] = new Location("Cave",
                "Une vielle cave, avec des toiles d'arreignées, des rats courent au moment où vous arrivez", true);
        tableau[1][1] = new Location("Trou dans le sol",
                "BAM ! Vous êtes tombés dans un trou. Heureusement, une corde vous permet d'en ressortir", true);
        tableau[1][2] = new Location("Salle de réception",
                "Des squelettes autour d'une table, ils devaient bien festoyer à l'époque.", false);
        tableau[1][3] = new Location("Couloir principal",
                "Un grand couloir, sur les côtés sont allignés des statues de gardes imposantes", true);
        tableau[2][0] = new Location("Une porte fermée", "C'est une porte, elle est fermée, rien de plus...", false);
        tableau[2][1] = new Location("Passage crasseux",
                "BEURK ! Un passage avec des toiles d'araignées, de l'eau croupie s'infiltre dans vos chaussures",
                true);
        tableau[2][2] = new Location("Escaliers",
                "Super, des escaliers ! Quelques marches sont endommagés mais vous parvenez à les enjamber", true);
        tableau[2][3] = new Location("Salle de torture",
                "Une salle de torture, avec des instruments de torture accrochés au mur.", false);


        // Création des objets
        Key key = new Key("Salle de torture","Clé ancienne","Une enorme clé qui sert surement à ouvrir une grosse salle");
        Puzzle puzzle = new Puzzle("Quel est l’animal totem du roi ?", "lion", "Salle du trône","Enigme1","Enigme qui représent un lion surment pour aller dans une salle noble");
        Letter letter = new Letter(puzzle,"Le lion doré", "Une Lettre semblant vieille mais on peut y distinguer des mots","Le vieux sage est toujour mouillé");
        Letter letter2 = new Letter(puzzle,"Le Drgagon blanc", "Un calice argenté","Le dragon blanc aux bourses bleues");


        // Ajout des objets à la salle de réception (1,1)
        tableau[0][0].addItem(key);
        tableau[0][0].addItem(letter);
        tableau[0][1].addItem(letter2);
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



}

