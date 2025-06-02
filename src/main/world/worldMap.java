package main.world;

import main.Game;

public class WorldMap {

    int rows = 3;
    int cols = 3;

    // Créer un tableau bidimensionnel
    Location[][] tableau = new Location[rows][cols];

    private WorldMap() {
        tableau[0][0] = new Location("Salle de stockage", "Une salle de stockage pour le vin et la nourriture", true);
        tableau[0][1] = new Location("Cave", "Une vielle cave, avec des toiles d'arreignées, des rats courent au moment où vous arrivez", true);
        tableau[0][2] = new Location("Une porte fermée", "C'est une porte, elle est fermée, rien de plus...", false);
        tableau[1][0] = new Location("Salle du trône", "Une salle gigantesque, pleine de reliques d'un ancien temps.", true);
        tableau[1][1] = new Location("Salle de réception", "Des squelettes autour d'une table, ils devaient bien festoyer à l'époque.", false);
    }
    public Location[][] getWorldMap() {
        return tableau;
    }

    private static WorldMap INSTANCE;
    public static WorldMap getWorldInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WorldMap();
        }
        return INSTANCE;}
}

