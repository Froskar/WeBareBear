package main.world;

import utils.Array2Dprinter;

public class worldMap {
    
	int rows = 10;
	int cols = 10;

	// Créer un tableau bidimensionnel
	Location[][] tableau = new Location[rows][cols];

    public worldMap() {
        tableau[2][2] = new Location("Salle de stockage", "Une salle de stockage pour le vin et la nourriture", true);
        tableau[2][3] = new Location("Cave", "Une vielle cave, avec des toiles d'arreignées, des rats courent au moment où vous arrivez", true);
        tableau[2][4] = new Location("Une porte fermée", "C'est une porte, elle est fermée, rien de plus...", false);
        tableau[2][5] = new Location("Salle du trône", "Une salle gigantesque, pleine de reliques d'un ancien temps.", false);
        tableau[3][3] = new Location("Salle de réception", "Des squelettes autour d'une table, ils devaient bien festoyer à l'époque.", false);
    }
    public Location[][] getWorldMap() {
        return tableau;
    }

    public void  displayMap() {
           String affichage = Array2Dprinter.print2DArray(tableau,0,0);
            System.out.println(affichage);
        }
    }

    

