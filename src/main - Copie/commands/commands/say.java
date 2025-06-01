package main.commands.commands;

import player.player;
import main.items.Letter;
import main.items.Puzzle;
import main.world.worldMap;
import main.world.Location;

import java.util.Scanner;

public class say  {

    private worldMap world;

    public say(worldMap world) {
        this.world = world;
    }

    public void sayAnswer(player player, Puzzle puzzle) {
        if (puzzle.isSolved()) {
            System.out.println("Vous avez déjà résolu cette énigme !");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Répondez à l'énigme : ");
        String response = scanner.nextLine();

        if (puzzle.trySolve(response)) {
            System.out.println("Bonne réponse ! Une clé est apparue.");
            // On débloque la salle
             unlockLocation(puzzle.getUnlocksLocation());
            // On ajoute la clé à l'inventaire du joueur
            player.addItem(new Letter(puzzle)); // 
        
           
        } else {
            System.out.println("Mauvaise réponse, réessayez.");
        }
    }

    private void unlockLocation(String locationName) {
        for (int i = 0; i < world.getWorldMap().length; i++) {
            for (int j = 0; j < world.getWorldMap()[0].length; j++) {
                Location loc = world.getWorldMap()[i][j];
                if (loc != null && loc.getName().equalsIgnoreCase(locationName)) {
                    loc.setState(true); // ajoute un setter dans Location si nécessaire
                    System.out.println(locationName + " est maintenant déverrouillée !");
                    return;
                }
            }
        }
        System.out.println("Erreur : salle introuvable.");
    }
}
